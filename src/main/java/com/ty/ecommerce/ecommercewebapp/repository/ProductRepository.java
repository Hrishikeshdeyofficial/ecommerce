package com.ty.ecommerce.ecommercewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ecommerce.ecommercewebapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	
}
