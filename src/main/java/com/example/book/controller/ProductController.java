package com.example.book.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.book.domain.Product;
import com.example.book.exception.NoProductsFoundUnderCategoryException;
import com.example.book.exception.ProductNotFoundException;
import com.example.book.service.ProductService;
import com.example.book.validation.UnitsInStockValidator;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	private UnitsInStockValidator unitsInStockValidator;	

	@ModelAttribute
	public void populateInMemoryRepo(Model model) {
		model.addAttribute("products", productService.getAllProducts());
	}

	@RequestMapping()
	public String list(Model model) {
		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		List<Product> products = productService.getProductsByCategory(productCategory);
		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, Model model,
			BindingResult result) {
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@Valid @ModelAttribute("newProduct") Product newProduct,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addProduct";
		}

		MultipartFile productImage = newProduct.getProductImage();
		MultipartFile pdfFile = newProduct.getPdfFile();

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(
						new File(rootDirectory + "resources\\images\\" + newProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}

		if (pdfFile != null && !pdfFile.isEmpty()) {
			try {
				pdfFile.transferTo(new File(rootDirectory + "resources\\pdf\\" + newProduct.getProductId() + ".pdf"));
			} catch (Exception e) {
				throw new RuntimeException("Pdf saving failed", e);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}

	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
		return "invalidPromoCode";
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.addValidators(unitsInStockValidator);
		binder.setAllowedFields("productId", "name", "unitPrice", "description", "manufacturer", "category",
				"unitsInStock", "productImage", "pdfFile", "language");
	}
}