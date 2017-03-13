package com.example.book.service;

import com.example.book.domain.Order;

public interface OrderService {

	void processOrder(String productId, int count);

	Long saveOrder(Order order);
}
