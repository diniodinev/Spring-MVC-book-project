package com.example.book.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.book.domain.Customer;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> customers;

	public InMemoryCustomerRepository() {
		customers = new ArrayList<>();

		Customer customer1 = new Customer(1l, "Ivan Ivanov", "Sofiq, st. Sarko Chernev 45, ap.7, et 12", null);
		Customer customer2 = new Customer(2l, "Dragan Petrov", "Dupnitsa, Ivan Kotyov, ap.71, et 19", null);

		customers.addAll(Arrays.asList(customer1, customer2));
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

}
