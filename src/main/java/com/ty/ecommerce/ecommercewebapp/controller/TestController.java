package com.ty.ecommerce.ecommercewebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.ecommerce.ecommercewebapp.dto.ResponseStructure;
import com.ty.ecommerce.ecommercewebapp.entity.Product;
import com.ty.ecommerce.ecommercewebapp.entity.Reviews;
import com.ty.ecommerce.ecommercewebapp.entity.UserOrder;
import com.ty.ecommerce.ecommercewebapp.entity.Users;
import com.ty.ecommerce.ecommercewebapp.service.OrderService;
import com.ty.ecommerce.ecommercewebapp.service.ProductService;
import com.ty.ecommerce.ecommercewebapp.service.ReviewsService;
import com.ty.ecommerce.ecommercewebapp.service.UserService;
import com.ty.ecommerce.ecommercewebapp.util.OrderHelper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/ecommerce")
public class TestController {

	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	@Autowired
	ReviewsService reviewService;
	@Autowired
	OrderService orderService;

	@Operation(description = "To save user info", summary = "user will be saved")
	@ApiResponses(value = @ApiResponse(description = "User Created", responseCode = "201"))
	@PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<Users>> saveUser(@RequestBody Users users) {

		return userService.saveUser(users);

	}
	
	@Operation(description = "To login user", summary = "User will be logged in")
	@ApiResponses(value = @ApiResponse(description = "User Login", responseCode = "200"))
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Users>> userLogin(@RequestParam String email,
			@RequestParam String password) {
		return userService.userLogin(email, password);
	}

	@Operation(description = "To save product info", summary = "Product will be saved")
	@ApiResponses(value = @ApiResponse(description = "Product Created", responseCode = "201"))
	@PostMapping("/saveproduct/{userId}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,
			@PathVariable int userId) {

		return productService.saveProduct(product, userId);

	}

	@Operation(description = "To update product info", summary = "Product will be updated")
	@ApiResponses(value = @ApiResponse(description = "Product Updated", responseCode = "204"))
	@PutMapping("/update/{shopperrid}/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,
			@PathVariable int shopperrid, @PathVariable int productId) {

		return productService.updateProduct(product, shopperrid, productId);

	}

	@Operation(description = "To delete product info", summary = "Product will be deleted")
	@ApiResponses(value = @ApiResponse(description = "Product Deleted", responseCode = "205"))
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@RequestParam int productId, @RequestParam int userId) {

		return productService.deleteProduct(productId, userId);

	}

	@Operation(description = "To fetch product info", summary = "Product will be saved")
	@ApiResponses(value = @ApiResponse(description = "Fetch All Products", responseCode = "203"))
	@GetMapping("/getallproducts")
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct() {

		return productService.getAllProducts();

	}

	@Operation(description = "To save review info", summary = "Review will be saved")
	@ApiResponses(value = @ApiResponse(description = "Review Created", responseCode = "201"))
	@PostMapping("/savereview/{userId}/{productId}")
	public ResponseEntity<ResponseStructure<Reviews>> saveReviews(@RequestBody Reviews review, @PathVariable int userId,
			@PathVariable int productId) {

		return reviewService.saveReview(review, userId, productId);

	}
	@Operation(description = "To fetch review info", summary = "Review will be fetched")
	@ApiResponses(value = @ApiResponse(description = "Fetch All Review", responseCode = "203"))
	@GetMapping("/getreview/{reviewId}/{userId}")
	public ResponseEntity<ResponseStructure<Reviews>> getReviewById(@PathVariable int reviewId, @PathVariable int userId) {

		return reviewService.getReviewById(reviewId, userId);

	}

	@Operation(description = "To delete review info", summary = "Review will be deleted")
	@ApiResponses(value = @ApiResponse(description = "Review Deleted", responseCode = "205"))
	@DeleteMapping("/deletereview")
	public ResponseEntity<ResponseStructure<String>> deleteReview(@RequestParam int reviewId, @RequestParam int userId) {

		return reviewService.deleteReview(reviewId, userId);

	}
	
	@Operation(description = "To save order info", summary = "order will be saved")
	@ApiResponses(value = @ApiResponse(description = "Order Created", responseCode = "201"))
	@PostMapping("/saveorder/{userId}")
	public ResponseEntity<ResponseStructure<UserOrder>> saveOrder(@RequestBody OrderHelper order, @PathVariable int userId) {

		return orderService.saveOrder(order, userId);

	}
	@Operation(description = "To fetch order info", summary = "order info will be fetched")
	@ApiResponses(value = @ApiResponse(description = "Fetch Order", responseCode = "203"))
	@GetMapping("/getorder/{orderId}/{userId}")
	public ResponseEntity<ResponseStructure<UserOrder>> getOrderById(@PathVariable int orderId, @PathVariable int userId) {

		return orderService.getOrderById(orderId, userId);	
	}

}
