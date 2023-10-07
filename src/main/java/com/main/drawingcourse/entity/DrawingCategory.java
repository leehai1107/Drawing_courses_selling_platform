package com.main.drawingcourse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DrawingCategories")
public class DrawingCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int drawCategoryId;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	private String drawCategoryName;
	
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

}
