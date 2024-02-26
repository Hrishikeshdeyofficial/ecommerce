package com.ty.ecommerce.ecommercewebapp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Reviews {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	private String reviewTitle;
	private String reviewBody;
	@CreationTimestamp
	private LocalDateTime reviewDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Product product;
}
