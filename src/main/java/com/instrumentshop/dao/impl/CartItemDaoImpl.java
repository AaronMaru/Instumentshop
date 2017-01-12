package com.instrumentshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instrumentshop.dao.CartItemDao;
import com.instrumentshop.model.Cart;
import com.instrumentshop.model.CartItem;

@SuppressWarnings("deprecation")
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItem();
		for(CartItem item : cartItems){
			removeCartItem(item);
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public CartItem getCartItemByProductId(int productId) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where productId = ?");
		query.setInteger(0, productId);
		session.flush();
		
		return (CartItem) query.uniqueResult();
	}

}
