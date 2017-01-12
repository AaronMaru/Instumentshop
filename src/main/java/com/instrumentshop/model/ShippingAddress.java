package com.instrumentshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "shippingaddresses")
public class ShippingAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7369519256223291410L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shippingAddress_seq_Id")
	@SequenceGenerator(name="shippingAddress_seq_Id", sequenceName="shippingAddress_seq_Id", allocationSize = 1, initialValue = 1)
	@Column
	private int shippingAddressId;
	private String StreetName;
	private String apartmentNumber;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	@OneToOne
	private Customer customer;

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ShippingAddress [shippingAddressId=" + shippingAddressId + ", StreetName=" + StreetName
				+ ", apartmentNumber=" + apartmentNumber + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zipCode=" + zipCode + "]";
	}
	
	
}
