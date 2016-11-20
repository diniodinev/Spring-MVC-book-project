package com.example.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.book.domain.Product;
import com.example.book.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

}
