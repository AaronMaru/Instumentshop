package com.instrumentshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instrumentshop.dao.CustomerDao;
import com.instrumentshop.model.Customer;
import com.instrumentshop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;

	public void addCustomer(Customer customer) {

		customerDao.addCustomer(customer);
		
	}

	public Customer getCustomerById(int customerId) {
		
		return customerDao.getCustomerById(customerId);
		
	}

	public List<Customer> getAllCustomer() {
		
		return customerDao.getAllCustomer();
		
	}

	public Customer getCustomerByUsername(String username) {
		
		return customerDao.getCustomerByUsername(username);
		
	}
	
	
	
}
