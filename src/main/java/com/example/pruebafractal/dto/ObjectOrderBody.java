package com.example.pruebafractal.dto;

import java.util.List;

import com.example.pruebafractal.entity.Order;

public class ObjectOrderBody {
	
	Order bodyOrder;
	List<DtoItemOrder> dtoBodyItemOrder;
	
	public ObjectOrderBody() {}
	
	public ObjectOrderBody(Order bodyOrder, List<DtoItemOrder> dtoBodyItemOrder) {
		this.bodyOrder = bodyOrder;
		this.dtoBodyItemOrder = dtoBodyItemOrder;
	}
	
	public Order getBodyOrder() {
		return bodyOrder;
	}
	
	public void setBodyOder(Order bodyOder) {
		this.bodyOrder = bodyOder;
	}
	
	public List<DtoItemOrder> getDtoBodyItemOrder() {
		return dtoBodyItemOrder;
	}
	
	public void setDtoBodyItemOrder(List<DtoItemOrder> dtoBodyItemOrder) {
		this.dtoBodyItemOrder = dtoBodyItemOrder;
	}
	
	
}
