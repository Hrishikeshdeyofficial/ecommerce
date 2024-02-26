package com.ty.ecommerce.ecommercewebapp.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private String orderName;
	private String orderInvoice;
	@CreationTimestamp
	private LocalDateTime shipmentTime;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;

	@JsonIgnore
	@ManyToOne
	private Users users;

}
