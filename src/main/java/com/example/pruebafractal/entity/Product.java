package com.example.pruebafractal.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="products")
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productid")
	private Long productId;
	
	@Column(name = "productname",nullable=false, unique=true)
	private String productName;
	
	@Column(name = "productprice",nullable=false)
	private float productPrice;
	
	//@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    //private List<ItemOrder> itemOrders;
	
	
	
	
	public Long getProductId() {
		return productId;
	}




	public void setProductId(Long productId) {
		this.productId = productId;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public float getProductPrice() {
		return productPrice;
	}




	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
