package com.instrumentshop.dao;

import java.util.List;

import com.instrumentshop.model.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomer();

	Customer getCustomerByUsername(String username);
}
