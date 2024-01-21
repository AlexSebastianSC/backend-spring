package com.example.pruebafractal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pruebafractal.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{


}