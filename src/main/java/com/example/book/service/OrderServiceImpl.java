package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.domain.Product;
import com.example.book.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void processOrder(String productId, int quantity) {
		Product productById = productRepository.getProductById(productId);
		if (productById.getUnitsInStock() < quantity) {
			throw new IllegalArgumentException(
					"Out of Stock. Available Units in stock" + productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}

}
