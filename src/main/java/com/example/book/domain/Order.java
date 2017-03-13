package com.example.book.domain;

import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = -3560539622417210365L;
	private Long orderId;
	private Cart cart;
	private Buyer customer;
	private ShippingDetail shippingDetail;

	public Order() {
		this.customer = new Buyer();
		this.shippingDetail = new ShippingDetail();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Buyer getCustomer() {
		return customer;
	}

	public void setCustomer(Buyer customer) {
		this.customer = customer;
	}

	public ShippingDetail getShippingDetail() {
		return shippingDetail;
	}

	public void setShippingDetail(ShippingDetail shippingDetail) {
		this.shippingDetail = shippingDetail;
	}

}