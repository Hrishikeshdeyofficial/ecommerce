package com.ty.ecommerce.ecommercewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ecommerce.ecommercewebapp.dao.ReviewsDao;
import com.ty.ecommerce.ecommercewebapp.dto.ResponseStructure;
import com.ty.ecommerce.ecommercewebapp.entity.Reviews;

@Service
public class ReviewsService {

	@Autowired
	ReviewsDao reviewsDao;

	public ResponseEntity<ResponseStructure<Reviews>> saveReview(Reviews review, int userId, int productId) {

		Reviews recievedReview = reviewsDao.saveReviews(review, userId, productId);

		ResponseStructure<Reviews> response = new ResponseStructure<Reviews>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(recievedReview);

		return new ResponseEntity<ResponseStructure<Reviews>>(response, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Reviews>> getReviewById(int reviewId, int userId) {

		Reviews recievedReview = reviewsDao.getReviewById(reviewId, userId);

		ResponseStructure<Reviews> response = new ResponseStructure<Reviews>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(recievedReview);

		return new ResponseEntity<ResponseStructure<Reviews>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteReview(int reviewId, int userId) {
		reviewsDao.deleteReview(reviewId, userId);
		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData("Data Removed Successfully");

		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);

	}
}
