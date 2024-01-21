package com.example.pruebafractal.dto;

import java.math.BigDecimal;

public class DtoOrder {

	private String orderDate;
	private Integer numProducts;
	private BigDecimal finalPrice;
	
	
	public DtoOrder() {}
	
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public Integer getNumProducts() {
		return numProducts;
	}
	
	public void setNumProducts(Integer numProducts) {
		this.numProducts = numProducts;
	}
	
	public BigDecimal getFinalPrice() {
		return finalPrice;
	}
	
	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	
}