package com.instrumentshop.dao.impl;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instrumentshop.dao.CartDao;
import com.instrumentshop.model.Cart;
import com.instrumentshop.service.CustomerOrderService;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	public Cart getCartById(int cartId) {
		
		Session session = sessionFactory.getCurrentSession();	
		
		return session.get(Cart.class, cartId);
	}
	
	public Cart validate(int cartId) throws IOException {

		Cart cart = getCartById(cartId);
		
		if(cart == null || cart.getCartItem().size() == 0){
			throw new IOException();
		}
		
		update(cart);
		return cart;
	}

	public void update(Cart cart) {

		int cartId = cart.getCartId();
		double grandTotal = customerOrderService.getCustomerGrandTotal(cartId);
		cart.setGrandTotal(grandTotal);
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}

	

}
