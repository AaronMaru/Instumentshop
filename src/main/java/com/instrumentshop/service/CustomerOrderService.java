package com.instrumentshop.service;

import com.instrumentshop.model.CustomerOrder;

public interface CustomerOrderService {

	void addCustomerOrder(CustomerOrder customerOrder);
	
	double getCustomerGrandTotal(int cartId);
	
}
