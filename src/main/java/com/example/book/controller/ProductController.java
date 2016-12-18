package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.book.domain.Product;
import com.example.book.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;

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

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct")  Product newProduct, Model model) {
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
		productService.addProduct(newProduct);
		return "redirect:/products";
	}	
}