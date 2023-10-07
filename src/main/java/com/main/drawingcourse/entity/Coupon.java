package com.main.drawingcourse.entity;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Coupons")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int couponId;
	
	@Column(unique = true,columnDefinition = "varchar(12) not null")
	private String couponCode;
	
	@Column
	private int discountPercentage;
	
	@Column
	private LocalDate expiryDate;
	
	@Column
	private int quantity;
	
	@OneToMany(mappedBy = "coupon")
	private Collection<Order> orders;

}
