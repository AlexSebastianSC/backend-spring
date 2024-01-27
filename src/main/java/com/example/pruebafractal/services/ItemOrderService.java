package com.example.pruebafractal.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.pruebafractal.dto.DtoConfirmMessage;
import com.example.pruebafractal.dto.DtoItemOrder;
import com.example.pruebafractal.entity.ItemOrder;
import com.example.pruebafractal.entity.ItemOrderId;
import com.example.pruebafractal.repositories.ItemOrderRepository;

import jakarta.transaction.Transactional;

@Service
public class ItemOrderService {
	@Autowired
	private ItemOrderRepository itemOrderRepository;
	
	@Autowired
	private OrderService orderService;
	 
	public List<ItemOrder> getAllItemsOrder(Long id){

		 /*List<ItemOrder> listItemOrders = itemOrderRepository.findAll();
		 if(listItemOrders.isEmpty()) {
			 return null;
		 }else {
			 return itemOrderRepository.findAll();
		 }*/
		
	    try {
		    List<ItemOrder> listItemOrders = itemOrderRepository.findItemsByOrderId(id);//.findById(id);//.findAll();
		    return listItemOrders.isEmpty() ? Collections.emptyList() : listItemOrders;
	    } catch (Exception e) {
	        throw new RuntimeException("Error al obtener todos los items de la orden", e);
	    }
	}
	
	public Optional<ItemOrder> getItemOrderById(ItemOrderId id) { //ver si no tiene
		
		/*Optional<ItemOrder> itemOrder = itemOrderRepository.findById(id);
		if(itemOrder.isEmpty()) {
			return null;
		}else {
			return itemOrderRepository.findById(id);
		}*/
		
		try {
	        Optional<ItemOrder> itemOrder = itemOrderRepository.findById(id);
	        return itemOrder.or(() -> Optional.empty());
	    } catch (Exception e) {
	        throw new RuntimeException("Error al obtener el item de la orden por ID", e);
	    }
    }
	
	
	
	@Transactional
	public DtoConfirmMessage updateItemOrder(List<ItemOrder> itemOrders) {//Update
	    
	    try {
	        if (itemOrders.isEmpty()) {
	            return new DtoConfirmMessage("Error: Lista vacía");
	        }
	        /*
	        List<ItemOrderId> idsItemOrderExisting = new ArrayList<ItemOrderId>();
	        for (ItemOrder item : itemOrders) {
	            if (!itemOrderRepository.findById(item.getId()).isPresent()) {
	            	//delete current ones
	            	idsItemOrderExisting.add(item.getId());
	                //return new DtoConfirmMessage("Error: incorrect ID (" + item.getId().getOrderId() + ", " + item.getId().getProductId() + ")");
	            }
	        }*/
	        Long orderId = itemOrders.get(0).getId().getOrderId();
	        	//itemOrderRepository.deleteAllById(idsItemOrderExisting);
	        	itemOrderRepository.deleteByOrderId(orderId);
		        itemOrderRepository.saveAll(itemOrders);
	        
	        
	        return new DtoConfirmMessage("Updating items");
	    } catch (Exception e) {
	        throw new RuntimeException("Error updating item order", e);
	    }
	}
	
	
	
	/*
	@Transactional
	public DtoConfirmMessage updateItemOrder(List<ItemOrder> newItemOrders) {
	    try {
	        List<ItemOrder> updatedItemOrders = new ArrayList<>();
	        List<ItemOrder> insertedItemOrders = new ArrayList<>();

	        for (ItemOrder newItemOrder : newItemOrders) {
	            Optional<ItemOrder> existingItemOrderOptional = itemOrderRepository.findById(newItemOrder.getId());
	            if (existingItemOrderOptional.isPresent()) {
	                ItemOrder existingItemOrder = existingItemOrderOptional.get();
	                
	                // Compara los campos para determinar si hay cambios
	                if (!existingItemOrder.equals(newItemOrder)) {
	                    // Actualiza el registro existente
	                    existingItemOrder.setQuantity(newItemOrder.getQuantity());
	                    existingItemOrder.setProductTotalPrice(newItemOrder.getProductTotalPrice());
	                    // Puedes actualizar otros campos según sea necesario

	                    updatedItemOrders.add(itemOrderRepository.save(existingItemOrder));
	                }
	            } else {
	                // Inserta el nuevo registro si no existe en la base de datos
	                insertedItemOrders.add(newItemOrder);
	            }
	        }

	        // Guarda los nuevos registros
	        itemOrderRepository.saveAll(insertedItemOrders);

	        // Crea un mensaje de confirmación
	        StringBuilder message = new StringBuilder("Actualización completada. ");
	        if (!updatedItemOrders.isEmpty()) {
	            message.append("Registros actualizados: ").append(updatedItemOrders.size()).append(". ");
	        }
	        if (!insertedItemOrders.isEmpty()) {
	            message.append("Registros insertados: ").append(insertedItemOrders.size()).append(".");
	        }

	        return new DtoConfirmMessage(message.toString());
	    } catch (Exception e) {
	        throw new RuntimeException("Error al actualizar e insertar ItemOrders", e);
	    }
	}
	*/
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public DtoConfirmMessage saveItemOrder(Long orderId,List<DtoItemOrder> dtoItemsOrder) { //Create
		/*if(dtoItemsOrder.isEmpty() && orderId==null) {
			return new DtoConfirmMessage("Error saving items");
		}
		
		List<ItemOrder> itemsOrder = new ArrayList<>();;
		for(DtoItemOrder item: dtoItemsOrder) {
			itemsOrder.add(new ItemOrder(new ItemOrderId(orderId,item.getProductid()),item.getProductName(), 
											item.getProductUnitPrice(),item.getQuantity(),
											item.getProductTotalPrice()));
		}
		itemOrderRepository.saveAll(itemsOrder);

		return new DtoConfirmMessage("Item(s) have been created");
		
		*/
		
		try {
	        if (dtoItemsOrder.isEmpty() || orderId == null) {
	            return new DtoConfirmMessage("Error saving items");
	        }

	        List<ItemOrder> itemsOrder = new ArrayList<>();
	        for (DtoItemOrder item : dtoItemsOrder) {
	            itemsOrder.add(new ItemOrder(new ItemOrderId(orderId, item.getProductid()), item.getProductName(),
	                    item.getProductUnitPrice(), item.getQuantity(), item.getProductTotalPrice()));
	        }
	        itemOrderRepository.saveAll(itemsOrder);

	        return new DtoConfirmMessage("Item(s) have been created");
	    } catch (Exception e) {
	        throw new RuntimeException("Error saving", e);
	    }
	}
	
	@Transactional
	public DtoConfirmMessage deleteItemsByOrderId(Long id) {
		
		/*List<ItemOrder> itemsOrder = itemOrderRepository.findItemsByOrderId(id);//.findById(id);
		if(itemsOrder.isEmpty()) {
			return new DtoConfirmMessage("Items doesnt exist");
		}
		itemOrderRepository.deleteAll(itemsOrder);		
		orderService.deleteOrder(id);
		return new DtoConfirmMessage("All Items of your order have been deleted");
		*/
		
		try {
	        List<ItemOrder> itemsOrder = itemOrderRepository.findItemsByOrderId(id);
	        if (itemsOrder.isEmpty()) {
	            return new DtoConfirmMessage("Los items no existen");
	        }
	        itemOrderRepository.deleteAll(itemsOrder);
	        orderService.deleteOrder(id);
	        return new DtoConfirmMessage("Todos los items de tu orden han sido eliminados");
	    } catch (Exception e) {
	        // Loguear el error o manejarlo de alguna manera, según tus necesidades.
	        throw new RuntimeException("Error al eliminar los items de la orden", e);
	    }
	}
	
	@Transactional
	public DtoConfirmMessage deleteItemsOrder(ItemOrderId id) {
		
		/*if(!itemOrderRepository.existsById(id)) {
			return new DtoConfirmMessage("Select Item doesnt exist");
		}
		itemOrderRepository.deleteById(id);
		return new DtoConfirmMessage("Item of your order have been deleted");
		
		*/
		
		try {
	        if (!itemOrderRepository.existsById(id)) {
	            return new DtoConfirmMessage("El item seleccionado no existe");
	        }
	        itemOrderRepository.deleteById(id);
	        return new DtoConfirmMessage("El item de tu orden ha sido eliminado");
	    } catch (Exception e) {
	        // Loguear el error o manejarlo de alguna manera, según tus necesidades.
	        throw new RuntimeException("Error al eliminar el item de la orden", e);
	    }
	}

}