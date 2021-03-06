package com.instrumentshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instrumentshop.dao.CustomerDao;
import com.instrumentshop.model.Authority;
import com.instrumentshop.model.Cart;
import com.instrumentshop.model.Customer;
import com.instrumentshop.model.Users;

@SuppressWarnings("deprecation")
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		

		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		
		Users newUser = new Users();
		newUser.setUsername(customer.getUsername());
		newUser.setPassword(customer.getPassword());
		newUser.setEnabled(true);
		newUser.setCustomerId(customer.getCustomerId());
		
		Authority newAuthority = new Authority();
		newAuthority.setUsername(customer.getUsername());
		newAuthority.setAuthority("ROLE_USER");
		
		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newAuthority);
		
		Cart newCart = new Cart();
		newCart.setCustomer(customer);
		customer.setCart(newCart);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(newCart);
		
		session.flush();
	}

	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class, customerId);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from Customer");
		List<Customer> customers = query.list();
		return customers;
	}

	@SuppressWarnings("rawtypes")
	public Customer getCustomerByUsername(String username) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where username = ?");
		query.setString(0, username);
		
		return (Customer) query.uniqueResult();
	}
	

}
