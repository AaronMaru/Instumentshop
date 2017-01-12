package com.instrumentshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instrumentshop.dao.CustomerOrderDao;
import com.instrumentshop.model.Cart;
import com.instrumentshop.model.CartItem;
import com.instrumentshop.model.CustomerOrder;
import com.instrumentshop.service.CartService;
import com.instrumentshop.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	@Autowired
	private CartService cartService;
	
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDao.addCustomerOrder(customerOrder);
		
	}

	public double getCustomerGrandTotal(int cartId) {

		double grandTotal = 0;
		Cart cart = cartService.getCartById(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		
		for(CartItem item : cartItems){
			grandTotal = item.getTotalPrice();
		}
		
		return grandTotal;
	}

}
