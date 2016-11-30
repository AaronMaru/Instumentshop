package com.instrumentshop.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.instrumentshop.dao.CartDao;
import com.instrumentshop.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	private Map<String, Cart> listOfCarts;

	public CartDaoImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}

	public Cart create(Cart cart) {

		if (listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(
					String.format("Cannot create a cart with the given id(%) already exists", cart.getCartId()));
		}

		listOfCarts.put(cart.getCartId(), cart);

		return cart;
	}

	public Cart read(String cartId) {

		return listOfCarts.get(cartId);
	}

	public void update(String cartId, Cart cart) {

		if (!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format("Can't update cart. The cart with the given id(%) doesn't exist", cart.getCartId()));
		}

		listOfCarts.put(cartId, cart);

	}

	public void delete(String cartId) {

		if (!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format("Can't delete cart. A cart with the given id(%) doesn't not exist", cartId));
		}
		
		listOfCarts.remove(cartId);
	}

}
