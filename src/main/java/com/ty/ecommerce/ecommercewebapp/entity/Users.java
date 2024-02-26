package com.ty.ecommerce.ecommercewebapp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;	
import lombok.Setter;

@Entity
@Setter
@Getter
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String password;

	@Column(unique = true)
	private String userEmail;
	private String userRole;

	@JsonIgnore
	@OneToMany(mappedBy = "users",  cascade = CascadeType.ALL)
	private List<Product> products;
	
	@JsonIgnore
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<UserOrder> orders;

}
