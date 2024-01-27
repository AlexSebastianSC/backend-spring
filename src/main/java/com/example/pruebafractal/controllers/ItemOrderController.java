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

import com.example.pruebafractal.dto.DtoItemOrder;
import com.example.pruebafractal.dto.ObjectItemOrderBody;
import com.example.pruebafractal.entity.ItemOrder;
import com.example.pruebafractal.entity.ItemOrderId;
import com.example.pruebafractal.services.ItemOrderService;

@RestController
@RequestMapping("/api/item-orders")
public class ItemOrderController {

	@Autowired
    private ItemOrderService itemOrderService;

	public ItemOrderController() {}
	
	@GetMapping("/{orderId}")
    public ResponseEntity<List<ItemOrder>> getAllItemOrders(@PathVariable("orderId") Long orderId) {
		try {
			List<ItemOrder> itemOrders = itemOrderService.getAllItemsOrder(orderId);
	        return !Objects.isNull(itemOrders)? ResponseEntity.ok(itemOrders) : ResponseEntity.noContent().build();
		}catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	@GetMapping("/{orderId}/{productId}")
    public ResponseEntity<Optional<ItemOrder>> getItemOrderById(@PathVariable("orderId") Long orderId, @PathVariable("productId") Long productId) {
		
		try {
			ItemOrderId item = new ItemOrderId(orderId,productId);
			Optional<ItemOrder> itemOrder= itemOrderService.getItemOrderById(item);
			return !Objects.isNull(itemOrder)? ResponseEntity.ok(itemOrder): ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/save")
    public ResponseEntity<String> saveItemOrder(@RequestBody ObjectItemOrderBody objectItemOrderBody) {
    	
    	try {
            List<DtoItemOrder> dtoItemOrder = objectItemOrderBody.getDtoItemOrder();
            Long idOrder = objectItemOrderBody.getIdOrder();
            itemOrderService.saveItemOrder(idOrder, dtoItemOrder);
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"Item(s) have been created\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving items");
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<String> upDateItemOrder(@RequestBody List<ItemOrder> itemsOrder) {
    	
    	try {
            itemOrderService.updateItemOrder(itemsOrder);
            return ResponseEntity.ok("{\"message\": \"Item(s) have been updated\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Error updating items\"}");
        }
    }
    
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteAllItemsOrder(@PathVariable("orderId") Long orderId) {
    	
    	try {
            itemOrderService.deleteItemsByOrderId(orderId);
            return ResponseEntity.ok("{\"message\": \"All Items of your order have been deleted\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Error deleting items\"}");
        }
    }
    
    @DeleteMapping("/delete/{orderId}/{productId}")
    public ResponseEntity<String> deleteItemsOrder(@PathVariable("orderId") Long orderId,@PathVariable("productId") Long productId) {
    	
    	try {
            ItemOrderId item = new ItemOrderId(orderId, productId);
            itemOrderService.deleteItemsOrder(item);
            return ResponseEntity.ok("{\"message\": \"Item of your order has been deleted\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Error deleting item\"}");
        }
    }
    
    
}