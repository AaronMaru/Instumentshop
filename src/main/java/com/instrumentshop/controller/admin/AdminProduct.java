package com.instrumentshop.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.instrumentshop.model.Product;
import com.instrumentshop.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

	private Path path;

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product/create")
	public String create(Model model){
		
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		
		model.addAttribute("product", product);
		return "admin/product/add";	
	}
	
	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	public String store(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
		
		System.out.println("product : " + product.toString());
		if(result.hasErrors()){
			return "admin/product/add";
		}
		productService.addProduct(product);
		imageUpload(product, request);
		
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value = "/product/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model){
		
		Product product = productService.getProductById(id);		
		model.addAttribute("product", product);
		return "admin/product/edit";
	}
	
	@RequestMapping(value = "/product/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("product") Product product,BindingResult result, HttpServletRequest request){
		
		if(result.hasErrors()){
			return "admin/product/edit";
		}
			
		imageUpload(product, request);
		productService.editProduct(product);
		
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value = "/product/{id}/delete")
	public String delete(@PathVariable int id, HttpServletRequest request){
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");
		
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		Product product = productService.getProductById(id);
		productService.deleteProduct(product);
		
		return "redirect:/admin/product";
	}
	
	private void imageUpload(Product product, HttpServletRequest request){
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
		
		if(productImage != null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed");
			}
		}
	}
}
