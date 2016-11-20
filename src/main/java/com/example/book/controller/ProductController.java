package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@ModelAttribute
	public void populateInMemoryRepo(Model model) {
		model.addAttribute("products", productService.getAllProducts());
	}

	@RequestMapping("/products")
	public String list(Model model) {
		return "products";
	}
}