package com.example.book.repository;

import com.example.book.domain.Order;

public interface OrderRepository {
	Long saveOrder(Order order);
}
