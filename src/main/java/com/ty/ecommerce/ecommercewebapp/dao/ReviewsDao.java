package com.ty.ecommerce.ecommercewebapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ecommerce.ecommercewebapp.entity.Product;
import com.ty.ecommerce.ecommercewebapp.entity.Reviews;
import com.ty.ecommerce.ecommercewebapp.entity.Users;
import com.ty.ecommerce.ecommercewebapp.exceptions.IdNotFoundException;
import com.ty.ecommerce.ecommercewebapp.repository.ProductRepository;
import com.ty.ecommerce.ecommercewebapp.repository.ReviewsRepository;
import com.ty.ecommerce.ecommercewebapp.repository.UserRepository;

@Repository
public class ReviewsDao {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ReviewsRepository reviewRepository;

	public Reviews saveReviews(Reviews review, int userId, int productId) {
		Users users=userRepository.findRoleByUserId(userId);
		if (users.getUserRole().equalsIgnoreCase("Customer")) {
			Optional<Product> product = productRepository.findById(productId);
			if (product.isPresent()) {
				review.setProduct(product.get());
				return reviewRepository.save(review);
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new IdNotFoundException();
		}

	}

	public Reviews getReviewById(int reviewId, int userId) {
		Users users= userRepository.findRoleByUserId(userId);
		Optional<Reviews> review = reviewRepository.findById(reviewId);
		if (users.getUserRole().equalsIgnoreCase("Merchant")) {
			if (review.isPresent()) {
				return review.get();
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new IdNotFoundException();
		}
	}

	public void deleteReview(int reviewId, int userId) {
		Optional<Reviews> review = reviewRepository.findById(reviewId);
		if (review.get() != null) {
			Optional<Users> user = userRepository.findById(userId);
			if ((user.get().getUserRole()).equalsIgnoreCase("Merchant")) {
				reviewRepository.delete(review.get());

			} else {
				throw new IdNotFoundException();
			}
		} else {
			throw new NullPointerException();
		}

	}

}
