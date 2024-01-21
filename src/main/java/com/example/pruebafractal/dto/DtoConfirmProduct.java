package com.example.pruebafractal.dto;

import java.util.Optional;

import com.example.pruebafractal.entity.Product;

public class DtoConfirmProduct {
	private String message;
	private Optional<Product> product;
	

	public DtoConfirmProduct() {}
	
	public DtoConfirmProduct(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Optional<Product> getProduct() {
		return product;
	}

	public void setProduct(Optional<Product> product) {
		this.product = product;
	}
	
	
	
}
