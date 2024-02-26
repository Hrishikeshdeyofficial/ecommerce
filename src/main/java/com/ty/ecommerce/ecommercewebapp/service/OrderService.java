package com.ty.ecommerce.ecommercewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ecommerce.ecommercewebapp.dao.UserOrderDao;
import com.ty.ecommerce.ecommercewebapp.dto.ResponseStructure;
import com.ty.ecommerce.ecommercewebapp.entity.Reviews;
import com.ty.ecommerce.ecommercewebapp.entity.UserOrder;
import com.ty.ecommerce.ecommercewebapp.util.OrderHelper;

@Service
public class OrderService {

	@Autowired
	UserOrderDao userOrderDao;

	public ResponseEntity<ResponseStructure<UserOrder>> saveOrder(OrderHelper order, int userId) {
		
		
		UserOrder recievedOrder = userOrderDao.saveOrders(order, userId);
		ResponseStructure<UserOrder> response = new ResponseStructure<UserOrder>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(recievedOrder);

		return new ResponseEntity<ResponseStructure<UserOrder>>(response, HttpStatus.CREATED);

	}


	public ResponseEntity<ResponseStructure<UserOrder>> getOrderById(int orderId, int userId) {
		
		UserOrder recievedOrder = userOrderDao.getOrderById(orderId, userId);
		ResponseStructure<UserOrder> response = new ResponseStructure<UserOrder>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(recievedOrder);

		return new ResponseEntity<ResponseStructure<UserOrder>>(response, HttpStatus.OK);

	}

}
