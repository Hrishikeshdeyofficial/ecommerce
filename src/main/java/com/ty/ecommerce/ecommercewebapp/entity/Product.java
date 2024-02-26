package com.ty.ecommerce.ecommercewebapp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private String productRating;
	private String productDesc;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Reviews> reviews;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "products", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<UserOrder> orders;
	
	@JsonIgnore
	@ManyToOne
	private Users users;
	
	}
