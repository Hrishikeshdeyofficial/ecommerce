package com.ty.ecommerce.ecommercewebapp.exceptions;

public class IdNotFoundException extends RuntimeException{

	String message = "You are Not Authorized to perform this operation";
	
	
	public String getMessage()
	{
		return message;
	}
}
	