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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	
	@Column(columnDefinition = "nvarchar(250)")
	private String comment;
	
	
	@Column(columnDefinition = "DATE")
	private LocalDate reviewDate;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Course_Order course_Order;
	

}
