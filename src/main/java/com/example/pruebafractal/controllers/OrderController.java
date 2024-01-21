package com.example.pruebafractal.controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pruebafractal.dto.DtoConfirmOrder;
import com.example.pruebafractal.dto.ObjectItemOrderBody;
import com.example.pruebafractal.dto.ObjectOrderBody;
import com.example.pruebafractal.entity.Order;
import com.example.pruebafractal.services.OrderService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
    private OrderService orderService;
	
	@Autowired
    private ItemOrderController itemOrderController;
    
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
    	try {
    		List<Order> listOrders = orderService.getAllOrders();
        	return !Objects.isNull(listOrders)? ResponseEntity.ok(listOrders) : ResponseEntity.noContent().build();
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    	
    }
    
    @GetMapping("/{orderId}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable("orderId") Long orderId) {
    	try {
    		Optional<Order> order = orderService.getOrderById(orderId);
            return !Objects.isNull(order)? ResponseEntity.ok(order) : ResponseEntity.noContent().build();
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    	
    }
    
    @Transactional
    @PutMapping("/save")			
    public ResponseEntity<String> saveOrder(@RequestBody ObjectOrderBody objectOrderBody) {
    	try {
    		DtoConfirmOrder orderId = orderService.saveOrder(objectOrderBody.getBodyOrder());
        	ObjectItemOrderBody objectItemOrderBody = new ObjectItemOrderBody(orderId.getOrderId(),objectOrderBody.getDtoBodyItemOrder());
        	itemOrderController.saveItemOrder(objectItemOrderBody);
        	return ResponseEntity.ok("Order saved successfully");
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving order");
    	}

    }
    
    
    @PutMapping("/update")
    public ResponseEntity<String> updateOrder(@RequestBody Order order) {
    	//orderService.updateOrder(order);
    	
    	try {
    		Object obj = orderService.updateOrder(order);
    		return !Objects.isNull(obj)? ResponseEntity.ok("Order updated successfully") : ResponseEntity.noContent().build();
            //return ResponseEntity.ok("Order updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating order");
        }
    }
    
    //Its just using when you delete all items of one product
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Long idOrder) {
   	
    	try {
            Object obj = orderService.deleteOrder(idOrder);
            return !Objects.isNull(obj)? ResponseEntity.ok("Order deleted successfully") : ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting order");
        }
    }
}