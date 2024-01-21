package com.example.pruebafractal.dto;

import java.util.List;

import com.example.pruebafractal.entity.Product;

public class DtoListProducts {
	private String message;
	private List<Product> products;
	
	public DtoListProducts(){}
	
	public DtoListProducts(String message) {
		this.message = message;
	}

	
	public DtoListProducts(String message,List<Product> products) {
		this.message = message;
		this.products = products;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
	
	
}
