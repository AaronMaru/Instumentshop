package com.instrumentshop.service;

import com.instrumentshop.model.Cart;

public interface CartService {

	Cart getCartById(int cartId);
	
	void update(Cart cart);
}
