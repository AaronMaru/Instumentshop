package com.instrumentshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.instrumentshop.model.Product;
import com.instrumentshop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String index(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		
		return "product/index";
	}
	
	@RequestMapping(value = "/{id}")
	public String show(@PathVariable int id, Model model){
		
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "product/show";
		
	}
}
