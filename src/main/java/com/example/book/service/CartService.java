package com.example.book.service;

import com.example.book.domain.Cart;

public interface CartService {

	Cart create(Cart cart);
	Cart read(String cartId);
	void update(String cartId, Cart cart);
	void delete(String cartId);	
}
