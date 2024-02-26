package com.ty.ecommerce.ecommercewebapp.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ecommerce.ecommercewebapp.dao.UserDao;
import com.ty.ecommerce.ecommercewebapp.dto.ResponseStructure;
import com.ty.ecommerce.ecommercewebapp.entity.Users;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Users>> saveUser(Users users) {
		Users recievedUser = userDao.saveUser(users);

		ResponseStructure<Users> response = new ResponseStructure<Users>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(recievedUser);

		return new ResponseEntity<ResponseStructure<Users>>(response, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Users>> userLogin(String email, String password) {
		Users recievedUser = userDao.login(email, password);

		ResponseStructure<Users> response = new ResponseStructure<Users>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(recievedUser);

		return new ResponseEntity<ResponseStructure<Users>>(response, HttpStatus.OK);

	}

}
