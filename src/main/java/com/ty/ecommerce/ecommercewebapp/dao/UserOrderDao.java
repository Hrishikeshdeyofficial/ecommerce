package com.ty.ecommerce.ecommercewebapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ecommerce.ecommercewebapp.entity.Product;
import com.ty.ecommerce.ecommercewebapp.entity.UserOrder;
import com.ty.ecommerce.ecommercewebapp.entity.Users;
import com.ty.ecommerce.ecommercewebapp.exceptions.IdNotFoundException;
import com.ty.ecommerce.ecommercewebapp.repository.ProductRepository;
import com.ty.ecommerce.ecommercewebapp.repository.UserOrderRepository;
import com.ty.ecommerce.ecommercewebapp.repository.UserRepository;
import com.ty.ecommerce.ecommercewebapp.util.OrderHelper;

@Repository
public class UserOrderDao {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserOrderRepository userOrderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public UserOrder saveOrders(OrderHelper order, int userId) {
		
		Optional<Users> user = userRepository.findById(userId);
		if(user.isPresent())
		{
			if(user.get().getUserRole().equalsIgnoreCase("Customer"))
			{
				List<Integer> productList = order.getProducts();
				List<Product> list=productRepository.findAllById(productList);
				if(list!=null) {
				   	order.getOrder().setProducts(list);
				   	order.getOrder().setUsers(user.get());
					return userOrderRepository.save(order.getOrder());
				}
				else {
					throw new NullPointerException();
				}
			}
			else {
				throw new IdNotFoundException();
			}
		}
		else
		{
			throw new NullPointerException();
		}
		
	}

	public UserOrder getOrderById(int orderId, int userId) {
		Users users= userRepository.findRoleByUserId(userId);
		Optional<UserOrder> order = userOrderRepository.findById(orderId);
		if (users.getUserRole().equalsIgnoreCase("Customer")) {
			if (order.isPresent()) {
				return order.get();
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new IdNotFoundException();
		}
	}

}
