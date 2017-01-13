package com.instrumentshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String register(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){

		if(result.hasErrors()){

			return "auth/register";
		}
		
		List<Customer> customers = customerService.getAllCustomer();
		for(int i=0; i<customers.size(); i++){
			if(customer.getCustomerEmail().equals(customers.get(i).getCustomerEmail())){
				model.addAttribute("emailMsg", "Email already exists");
				
				return "auth/register";
			}
			
			if(customer.getUsername().equals(customers.get(i).getUsername())){
				model.addAttribute("usernameMsg", "Username already exists");
				
				return "auth/register";
			}
		}
		
		customer.setEnabled(true);
		customerService.addCustomer(customer);
		
		return "auth/registerCustomerSuccess";
	}
}
