package com.example.pruebafractal.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderid")
	private Long orderId;
	
	@Column(name="orderdate")
	private String orderDate;
	
	@Column(name="numproducts")
	private int numProducts;
	
	@Column(name="finalprice")
	private float finalPrice;
	
	public Order() {
		
	}

    public Order(String orderDate, int numProducts, float finalPrice) {
		this.orderDate = orderDate;
		this.numProducts = numProducts;
		this.finalPrice = finalPrice;
	}

	//private List<ItemOrder> itemOrders;

	public Long getOrderId() {
		return orderId;
	}



	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}



	public String getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}



	public int getNumProducts() {
		return numProducts;
	}



	public void setNumProducts(int numProducts) {
		this.numProducts = numProducts;
	}



	public float getFinalPrice() {
		return finalPrice;
	}



	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
