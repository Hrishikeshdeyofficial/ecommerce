package com.ty.ecommerce.ecommercewebapp.util;

import java.util.List;

import com.ty.ecommerce.ecommercewebapp.entity.UserOrder;

public class OrderHelper {

	private UserOrder order;
	private List<Integer> products;

	public UserOrder getOrder() {
		return order;
	}

	public void setOrder(UserOrder order) {
		this.order = order;
	}

	public List<Integer> getProducts() {
		return products;
	}

	public void setProducts(List<Integer> products) {
		this.products = products;
	}

}
