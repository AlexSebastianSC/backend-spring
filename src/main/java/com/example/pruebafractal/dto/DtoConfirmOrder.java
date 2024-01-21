package com.example.pruebafractal.dto;

public class DtoConfirmOrder {
	private String message;
	private Long orderId;
	
	public DtoConfirmOrder() {}
	
	public DtoConfirmOrder(String message, Long orderId) {
		this.message = message;
		this.orderId = orderId;
	}
	
	public DtoConfirmOrder(String message) {
		this.message = message;
	}
	
	public DtoConfirmOrder(Long orderId) {
		this.orderId = orderId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	
	
	
}