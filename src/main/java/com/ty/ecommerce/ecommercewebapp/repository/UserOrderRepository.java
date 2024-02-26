package com.ty.ecommerce.ecommercewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ecommerce.ecommercewebapp.entity.UserOrder;
import com.ty.ecommerce.ecommercewebapp.util.OrderHelper;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer>{

	UserOrder save(OrderHelper order);

}
