package com.instrumentshop.service;

import java.util.List;

import com.instrumentshop.model.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	Customer getCustomerByUsername(String username);
	
	List<Customer> getAllCustomer();
	
}
