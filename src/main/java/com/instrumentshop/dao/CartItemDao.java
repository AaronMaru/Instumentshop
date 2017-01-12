package com.instrumentshop.dao;

import com.instrumentshop.model.Cart;
import com.instrumentshop.model.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
		
	CartItem getCartItemByProductId(int productId);
	
}
