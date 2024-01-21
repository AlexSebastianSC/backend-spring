package com.example.pruebafractal.services;

import java.util.Collections;
//import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.pruebafractal.dto.DtoConfirmMessage;
import com.example.pruebafractal.dto.DtoConfirmOrder;
import com.example.pruebafractal.entity.Order;
import com.example.pruebafractal.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public List<Order> getAllOrders(){
		try {
			List<Order> list =  orderRepository.findAll();
			if(list.isEmpty()) {
				return Collections.emptyList();
			}else {
				return orderRepository.findAll();
			}
		}catch(Exception e) {
			throw new RuntimeException("Error getting orders", e);
		}
	}
	
	public Optional<Order> getOrderById(Long orderId) {
		try {
			Optional<Order> order = orderRepository.findById(orderId);
			return order.isPresent() ? order : Optional.empty();
		}catch(Exception e) {
			throw new RuntimeException("Error getting order  by ID", e);
		}
	}
	
	
	@Transactional
	public DtoConfirmMessage updateOrder(Order order) { //Update

		/*
		if(!orderRepository.findById(order.getOrderId()).isPresent()) {
			return new DtoConfirmMessage("Error: object doesnt exist");
		}
	    orderRepository.save(order);
	    return new DtoConfirmMessage("order updated");*/
	    
	    try {
	        Optional<Order> existingOrder = orderRepository.findById(order.getOrderId());

	        if (existingOrder.isPresent()) {
	            orderRepository.save(order);
	            return new DtoConfirmMessage("Order updated");
	        } else {
	            return new DtoConfirmMessage("Error: Order doesn't exist");
	        }
	    } catch (Exception e) {
	        // Loguear el error o manejarlo de alguna manera, según tus necesidades.
	        // También podrías lanzar una excepción personalizada si es necesario.
	        throw new RuntimeException("Error al actualizar la orden", e);
	    }
	    
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public DtoConfirmOrder saveOrder(Order order) {
		
		try {
	        if (Objects.isNull(order)) {
	            return new DtoConfirmOrder("Error: Object is null");
	        }
	        
	        Order newOrder = orderRepository.save(order);
	        return new DtoConfirmOrder("Order has been created", newOrder.getOrderId());
	    } catch (Exception e) {
	        throw new RuntimeException("Error al crear la orden", e);
	    }
	}
	

	@Transactional
	public DtoConfirmMessage deleteOrder(Long orderId) {
		/*if(!orderRepository.findById(orderId).isPresent()) {
			return new DtoConfirmMessage("Order doesnt exists");
		}
		orderRepository.deleteById(orderId);
		return new DtoConfirmMessage("Order deleted");*/
		
		try {
	        Optional<Order> existingOrder = orderRepository.findById(orderId);

	        if (existingOrder.isPresent()) {
	            orderRepository.deleteById(orderId);
	            return new DtoConfirmMessage("Order deleted");
	        } else {
	            return new DtoConfirmMessage("Error: Order doesn't exist");
	        }
	    } catch (Exception e) {
	        // Loguear el error o manejarlo de alguna manera, según tus necesidades.
	        // También podrías lanzar una excepción personalizada si es necesario.
	        throw new RuntimeException("Error al eliminar la orden", e);
	    }
		
	}

}