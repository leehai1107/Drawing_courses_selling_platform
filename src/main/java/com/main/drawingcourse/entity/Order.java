package com.main.drawingcourse.entity;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(unique = true,columnDefinition = "varchar(10) not null")
	private String orderCode;
	
	@Column
	private LocalDate orderDate;
	
	@Column
	private Double price;

	@Column
	private Boolean orderStatus;
	
	@OneToMany(mappedBy = "order")
	private Collection<Review> reviews;
	
	@ManyToMany(mappedBy = "orders")
	private Collection<Course> courses;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
}
