package com.ty.ecommerce.ecommercewebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ecommerce.ecommercewebapp.entity.Users;
import com.ty.ecommerce.ecommercewebapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public Users saveUser(Users user) {

		return userRepository.save(user);
	}

	public Users login(String email, String password) {
		Users user = userRepository.findByUserEmailAndPassword(email, password);
		return user;
	}

}
