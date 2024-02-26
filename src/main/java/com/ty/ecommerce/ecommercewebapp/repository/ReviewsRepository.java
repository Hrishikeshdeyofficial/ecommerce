package com.ty.ecommerce.ecommercewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ecommerce.ecommercewebapp.entity.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer>{
	
}
