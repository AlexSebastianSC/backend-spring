package com.example.pruebafractal.controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebafractal.dto.DtoConfirmProduct;
//import com.example.pruebafractal.entity.Order;
import com.example.pruebafractal.entity.Product;

import com.example.pruebafractal.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController{

	@Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
    	//List<Product> listProducts = productService.getAllProducts().getProducts();
        //return !Objects.isNull(listProducts)? ResponseEntity.ok(listProducts) : ResponseEntity.noContent().build();
        
        try {
            List<Product> listProducts = productService.getAllProducts().getProducts();
            //return ResponseEntity.ok(listProducts);
            return !Objects.isNull(listProducts)? ResponseEntity.ok(listProducts) : ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("productId") Long productid){
    	//DtoConfirmProduct productConfirm = productService.getProductById(productid);
    	//return !Objects.isNull(productConfirm.getProduct())? ResponseEntity.ok(productConfirm.getProduct()) : ResponseEntity.noContent().build();
    	
    	try {
            DtoConfirmProduct productConfirm = productService.getProductById(productid);
            return !Objects.isNull(productConfirm.getProduct())? ResponseEntity.ok(productConfirm.getProduct()) : ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    
    }
    
    
   
}