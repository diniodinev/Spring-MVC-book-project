package com.example.book.domain;

import java.util.List;

public class Customer {

	private long customerId;
	private String name;
	private String address;
	private List<Long> noOfOrdersMade;

	public Customer(long customerId, String name, String address, List<Long> noOfOrdersMade) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.noOfOrdersMade = noOfOrdersMade;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Long> getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(List<Long> noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

}
