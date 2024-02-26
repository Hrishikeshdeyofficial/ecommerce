package com.ty.ecommerce.ecommercewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ecommerce.ecommercewebapp.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByUserEmailAndPassword(String email, String password);
	Users findRoleByUserId(int id);
}
