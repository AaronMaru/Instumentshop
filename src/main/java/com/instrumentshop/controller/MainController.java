package com.instrumentshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.instrumentshop.dao.ProductDao;
import com.instrumentshop.model.Product;

@Controller
public class MainController {

	
	@Autowired
	private ProductDao productdao;
	
	@RequestMapping("/")
	public String home(){
	
		return "home";
	}
	
	@RequestMapping("/product")
	public String productList(Model model){
		
		model.addAttribute("products", productdao.getProductList());
		return "product/index";
	}
	
	@RequestMapping("/product/{id}")
	public String productShow(@PathVariable int id, Model model){
		
		Product product = productdao.getProductById(id);		
		model.addAttribute("product", product);
		return "product/show";
	}
	
	
}
