package com.example.pruebafractal.dto;

import java.util.List;

public class ObjectItemOrderBody {
	Long idOrder;
	List<DtoItemOrder> dtoItemOrder;
	
	public ObjectItemOrderBody(Long idOrder, List<DtoItemOrder> dtoItemOrder) {
		this.idOrder = idOrder;
		this.dtoItemOrder = dtoItemOrder;
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public List<DtoItemOrder> getDtoItemOrder() {
		return dtoItemOrder;
	}

	public void setDtoItemOrder(List<DtoItemOrder> dtoItemOrder) {
		this.dtoItemOrder = dtoItemOrder;
	}
	
	
	
	
}
