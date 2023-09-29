package com.main.drawingcourse.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pruchases")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pruchaseId;
	
	@Column(unique = true)
	private String pruchaseCode;
	
	@Column
	private LocalDate purchaseDate;

	@Column
	private Boolean pruchaseStatus;
	
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
}
