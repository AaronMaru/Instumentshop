package com.instrumentshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.instrumentshop.model.Product;
import com.instrumentshop.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHome {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("")
	public String adminPage(){
		return "admin/index";
	}
	
	@RequestMapping("/product")
	public String productList(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "admin/product/index";
	}
	
	@RequestMapping("/customer")
	public String customerList(){
		return "";
	}
}
