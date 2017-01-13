package com.instrumentshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.instrumentshop.model.Cart;
import com.instrumentshop.model.Customer;
import com.instrumentshop.model.CustomerOrder;
import com.instrumentshop.service.CartService;
import com.instrumentshop.service.CustomerOrderService;

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerOrderService customerService;

	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId){
		CustomerOrder customerOrder = new CustomerOrder();
		Cart cart = cartService.getCartById(cartId);
		customerOrder.setCart(cart);

		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAdress(customer.getShippingAddress());
		
		customerService.addCustomerOrder(customerOrder);
		
		return "redirect:/checkout?cartId=" + cartId;
	}
	
}
