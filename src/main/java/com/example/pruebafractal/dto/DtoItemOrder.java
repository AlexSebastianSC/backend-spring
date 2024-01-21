package com.example.pruebafractal.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DtoItemOrder {
	
	@JsonProperty("productId")
	private Long productId;
	private String productName;
	private BigDecimal productUnitPrice;
	private Integer quantity;
	private BigDecimal productTotalPrice;
	
	public DtoItemOrder() {		
	}
	
	public long getProductid() {
		return productId;
	}
	public void setProductid(Long productid) {
		this.productId = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(BigDecimal productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getProductTotalPrice() {
		return productTotalPrice;
	}
	public void setProductTotalPrice(BigDecimal productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}
	
	
	
}
