package com.example.pruebafractal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pruebafractal.entity.ItemOrder;
import com.example.pruebafractal.entity.ItemOrderId;

//import jakarta.transaction.Transactional;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, ItemOrderId >{
	
	Optional<ItemOrder> findById(ItemOrderId id);
	//void saveAll(ItemOrder[] itemOrder);
	//List<ItemOrder> saveAll(Iterable<ItemOrder> itemOrders);

	
	@Modifying
	@Query(value = "DELETE FROM items_orders i WHERE i.orderId = :orderId", nativeQuery = true)
	void deleteByOrderId(@Param("orderId") Long orderId);
	
	
	@Query(value = "SELECT * FROM items_orders i WHERE i.orderId = :orderId", nativeQuery = true)
	List<ItemOrder> findItemsByOrderId(Long orderId);
}
 