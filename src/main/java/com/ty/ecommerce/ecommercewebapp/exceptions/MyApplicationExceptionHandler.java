package com.ty.ecommerce.ecommercewebapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.ecommerce.ecommercewebapp.dto.ResponseStructure;

@ControllerAdvice
public class MyApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdNotFoundException(IdNotFoundException exception)
	{
		ResponseStructure<String> response = new ResponseStructure<String>();
		
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("Not Found");
		response.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseStructure<String>> catchNullPointerException(NullPointerException exception)
	{
		ResponseStructure<String> response = new ResponseStructure<String>();
		
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("Not Found");
		response.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_REQUEST);
	}
	
}