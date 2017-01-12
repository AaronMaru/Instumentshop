package com.instrumentshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instrumentshop.dao.CartDao;
import com.instrumentshop.model.Cart;
import com.instrumentshop.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	public Cart getCartById(int cartId) {
		
		return cartDao.getCartById(cartId);
	}

	public void update(Cart cart) {
		
		cartDao.update(cart);
	}

}
