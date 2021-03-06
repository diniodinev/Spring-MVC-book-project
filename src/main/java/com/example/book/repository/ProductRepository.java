package com.example.book.repository;

import java.util.List;

import com.example.book.domain.Product;

public interface ProductRepository {

	List<Product> getAllProducts();	
	
	Product getProductById(String productID);
	
	List<Product> getProductsByCategory(String category);
	
	void addProduct(Product product);
}
