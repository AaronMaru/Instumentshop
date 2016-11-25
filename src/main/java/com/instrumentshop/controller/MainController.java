package com.instrumentshop.controller;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.instrumentshop.dao.ProductDao;
import com.instrumentshop.model.Product;

@Controller
public class MainController {

	private Path path;
	
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
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin/index";
	}
	
	@RequestMapping("/admin/product")
    public String adminProductList(Model model){

        model.addAttribute("products", productdao.getProductList());

        return "admin/product/index";
    }
	
	@RequestMapping("/admin/product/add")
    public String adminProductAdd(Model model){

        Product product = new Product();
        product.setProductcategory("instrument");
        product.setProductcondition("new");
        product.setProductstatus("active");
        product.setProductprice(0.0);
        model.addAttribute(product);
        return "admin/product/add";
    }
	
	@RequestMapping(value = "/admin/product/add", method = RequestMethod.POST)
    public String adminProductStore(@ModelAttribute("product") Product product, HttpServletRequest request){

		ImageUpload(product, request);
        productdao.addProduct(product);
        return "redirect:/admin/product";

	}
	
	@RequestMapping("/admin/product/{id}")
	public String adminProductShow(@PathVariable int id, Model model){
		
		Product product = productdao.getProductById(id);		
		model.addAttribute("product", product);
		return "admin/product/show";
	}
	
	@RequestMapping("/admin/product/edit/{id}")
    public String adminProductEdit(@PathVariable("id") int id, Model model){
		
        Product product = productdao.getProductById(id);
        model.addAttribute("product", product);
        return "admin/product/edit";

    }
	
	@RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
    public String adminProductUpdate(@ModelAttribute("product") Product product, HttpServletRequest request){
		
        ImageUpload(product, request);
        productdao.editProduct(product);
        return "redirect:/admin/product";

    }
	
	@RequestMapping("/admin/product/delete/{id}")
    public String adminProductDelete(@PathVariable int id, HttpServletRequest request){

        Product product = productdao.getProductById(id);
        productdao.deleteProduct(product);

        return "redirect:/admin/product";
    }
	
	
	private void ImageUpload(Product product, HttpServletRequest request){
        MultipartFile productImage = product.getProductimage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductname() + ".png");
        System.out.println(path);
        if(productImage != null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("Product image saving failed", ex);
            }
        }

    }
}
