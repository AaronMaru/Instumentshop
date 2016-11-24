package com.instrumentshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
    private String productname;
    private String productcategory;
    private String productdescription;
    private double productprice;
    private String productcondition;
    private String productstatus;
    private int unitinstock;
    private String productmanufacturer;
    
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productname=" + productname + ", productcategory="
				+ productcategory + ", productdescription=" + productdescription + ", productprice=" + productprice
				+ ", productcondition=" + productcondition + ", productstatus=" + productstatus + ", unitinstock="
				+ unitinstock + ", productmanufacturer=" + productmanufacturer + "]";
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public String getProductcondition() {
		return productcondition;
	}
	public void setProductcondition(String productcondition) {
		this.productcondition = productcondition;
	}
	public String getProductstatus() {
		return productstatus;
	}
	public void setProductstatus(String productstatus) {
		this.productstatus = productstatus;
	}
	public int getUnitinstock() {
		return unitinstock;
	}
	public void setUnitinstock(int unitinstock) {
		this.unitinstock = unitinstock;
	}
	public String getProductmanufacturer() {
		return productmanufacturer;
	}
	public void setProductmanufacturer(String productmanufacturer) {
		this.productmanufacturer = productmanufacturer;
	}
}
