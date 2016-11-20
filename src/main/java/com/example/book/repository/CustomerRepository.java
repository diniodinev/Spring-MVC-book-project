package com.example.book.repository;

import java.util.List;

import com.example.book.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
