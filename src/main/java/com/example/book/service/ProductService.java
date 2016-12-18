package com.example.book.service;

import java.util.List;

import com.example.book.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(String productID);

	List<Product> getProductsByCategory(String category);

	void addProduct(Product product);
}
