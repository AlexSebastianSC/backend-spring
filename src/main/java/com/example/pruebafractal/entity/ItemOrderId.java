package com.example.pruebafractal.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class ItemOrderId implements Serializable {

	
	@Column(name = "orderid") 
	private Long orderId;
	
	@Column(name = "productid") 
	private Long productId;
	

	public ItemOrderId(Long orderId, Long productId) {
		this.orderId = orderId;
		this.productId = productId;
	};
	public ItemOrderId() {};
	
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
