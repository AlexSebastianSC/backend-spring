package com.example.pruebafractal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebafractal.dto.DtoConfirmProduct;
import com.example.pruebafractal.dto.DtoListProducts;
import com.example.pruebafractal.entity.Product;
import com.example.pruebafractal.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public DtoListProducts getAllProducts(){
		try {
			List<Product> listProduct = productRepository.findAll();
			if(listProduct.isEmpty()){
				return null;
			}else {
				//productRepository.findAll();
				return new DtoListProducts("Products loaded",listProduct);
			}
		}catch(Exception err) {
			return new DtoListProducts("Products error loaded");
		}
	}
	
	public DtoConfirmProduct getProductById(Long productId){
		try {
			Optional<Product> product = productRepository.findById(productId);
			if(!product.isPresent()) {
				return null;
			}
			DtoConfirmProduct productConfirm = new DtoConfirmProduct();
			Optional<Product> productF = productRepository.findById(productId);
			productConfirm.setProduct(productF);//get()
			return productConfirm;
			
		}catch(Exception err) {
			return new DtoConfirmProduct("Product doesnt exist");
		}
		
	}
	
	
	
}
