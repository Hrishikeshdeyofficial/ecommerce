package com.ty.ecommerce.ecommercewebapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ecommerce.ecommercewebapp.entity.Product;
import com.ty.ecommerce.ecommercewebapp.entity.Users;
import com.ty.ecommerce.ecommercewebapp.exceptions.IdNotFoundException;
import com.ty.ecommerce.ecommercewebapp.repository.ProductRepository;
import com.ty.ecommerce.ecommercewebapp.repository.UserRepository;

@Repository
public class ProductDao {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserRepository userRepository;

	
	public Product saveProducts(Product product, int id) {

		Optional<Users> user = userRepository.findById(id);
		if ((user.get().getUserRole()).equalsIgnoreCase("Merchant")) {
			product.setUsers(user.get());
			return productRepository.save(product);
		} else {
			throw new IdNotFoundException();
		}

	}

	public Product updateProduct(Product product, int id, int productId) {
		Users users=userRepository.findRoleByUserId(id);
		if (users.getUserRole().equalsIgnoreCase("Merchant")) {
			
			Optional<Product> productById = productRepository.findById(productId);
			productById.get().setProductName(product.getProductName());
			productById.get().setProductDesc(product.getProductDesc());
			productById.get().setProductRating(product.getProductRating());

			return productRepository.save(productById.get());
		} else {
			throw new IdNotFoundException();
		}

	}

	public void deleteProducts(int productId, int userId) {

		Optional<Product> product = productRepository.findById(productId);
		if (product.get() != null) {
			Optional<Users> user = userRepository.findById(userId);
			if ((user.get().getUserRole()).equalsIgnoreCase("Merchant")) {
				productRepository.delete(product.get());

			} else {
				throw new IdNotFoundException();
			}
		} else {
			throw new NullPointerException();
		}

	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

}
