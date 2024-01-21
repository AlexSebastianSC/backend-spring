package com.example.pruebafractal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebafractal.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
