package com.instrumentshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instrumentshop.model.BillingAddress;
import com.instrumentshop.model.Customer;
import com.instrumentshop.model.ShippingAddress;
import com.instrumentshop.service.CustomerService;

@Controller
public class RegisterCustomer {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register")
	public String showRegisterForm(Model model){
		
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		
		model.addAttribute("customer", customer);
		return "auth/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("customer") Customer customer, Model model){
		System.out.println("customer : " + customer.toString());
		customer.setEnabled(true);
		customerService.addCustomer(customer);
		
		return "auth/registerCustomerSuccess";
	}
}
