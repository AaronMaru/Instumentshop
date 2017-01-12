package com.instrumentshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carts")
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8501568928429557984L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cart_seq_Id")
	@SequenceGenerator(name="cart_seq_Id", sequenceName="cart_seq_Id", allocationSize = 1, initialValue = 1)
	@Column
	private int cartId;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItem;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;
	
	private double grandTotal;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItem=" + cartItem + ", customer=" + customer + ", grandTotal="
				+ grandTotal + "]";
	}

	

}
