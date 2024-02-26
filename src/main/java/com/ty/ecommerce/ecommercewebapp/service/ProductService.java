package com.ty.ecommerce.ecommercewebapp.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ecommerce.ecommercewebapp.dao.ProductDao;
import com.ty.ecommerce.ecommercewebapp.dto.ResponseStructure;
import com.ty.ecommerce.ecommercewebapp.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int id) {
		Product recievedProduct = productDao.saveProducts(product, id);

		ResponseStructure<Product> response = new ResponseStructure<Product>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(recievedProduct);

		return new ResponseEntity<ResponseStructure<Product>>(response, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, int id, int productId) {
		Product recievedProduct = productDao.updateProduct(product, id, productId);

		ResponseStructure<Product> response = new ResponseStructure<Product>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(recievedProduct);

		return new ResponseEntity<ResponseStructure<Product>>(response, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int productId, int userId) {

		productDao.deleteProducts(productId, userId);
		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData("Data Removed Successfully");

		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {
		
		List<Product> productList = productDao.getAllProducts();
		
		ResponseStructure<List<Product>> response = new ResponseStructure<List<Product>>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(productList); 

		return new ResponseEntity<ResponseStructure<List<Product>>>(response, HttpStatus.OK);
	}

	

}
