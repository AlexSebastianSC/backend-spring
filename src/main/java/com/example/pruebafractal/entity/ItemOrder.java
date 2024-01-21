package com.example.pruebafractal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="items_orders")
public class ItemOrder implements Serializable{
	

	@EmbeddedId
	@JsonProperty("id")
    private ItemOrderId id;

	
	@Column(name="productname")
	private String productName;
	
	@Column(name="productunitprice")
	private BigDecimal productUnitPrice;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="producttotalprice")
	private BigDecimal productTotalPrice;
	
	public ItemOrder(ItemOrderId itemOrderId) {
		this.id= itemOrderId;
	}
	
	
	public ItemOrder(String productName, BigDecimal productUnitPrice, Integer quantity, BigDecimal productTotalPrice) {
		this.productName = productName;
		this.productUnitPrice = productUnitPrice;
		this.quantity = quantity;
		this.productTotalPrice = productTotalPrice;
	}



	public ItemOrder() {}
	


	public ItemOrder(ItemOrderId id, String productName, BigDecimal productUnitPrice, Integer quantity,
			BigDecimal productTotalPrice) {
		this.id = id;
		this.productName = productName;
		this.productUnitPrice = productUnitPrice;
		this.quantity = quantity;
		this.productTotalPrice = productTotalPrice;
	}

	public ItemOrderId getId() {
		return id;
	}






	public void setId(ItemOrderId id) {
		this.id = id;
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






	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
