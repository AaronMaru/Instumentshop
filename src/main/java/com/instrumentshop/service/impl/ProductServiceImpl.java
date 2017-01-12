package com.instrumentshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instrumentshop.dao.ProductDao;
import com.instrumentshop.model.Product;
import com.instrumentshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	@Transactional
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productDao.getProductList();
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.addProduct(product);
	}

	public void editProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.editProduct(product);
	}

	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(product);
	}
	
}
