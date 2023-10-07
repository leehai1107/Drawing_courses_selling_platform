package com.main.drawingcourse.entity;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(unique = true,columnDefinition = "varchar(10) not null")
	private String orderCode;
	
	@Column
	private LocalDate orderDate;

	@Column
	private Boolean orderStatus;
	
	@OneToMany(mappedBy = "order")
	private Collection<Review> reviews;
	
	@OneToMany(mappedBy = "order")
	private Collection<Course> courses;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "couponId")
	private Coupon coupon;
}
