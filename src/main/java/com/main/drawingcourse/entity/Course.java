package com.main.drawingcourse.entity;

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
@Table(name = "Courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@Column
	private String title;
	
	@Column(columnDefinition = "nvarchar(MAX) not null")
	private String description;
	
	@Column
	private Double price;
	
	@Column
	private Integer rating;
	
	@Column
	private Float progress;
	
	@ManyToOne
	@JoinColumn(name = "instructorId")
	private User user;
	
	@OneToMany(mappedBy = "course")
	private Collection<Level> levels;
	
	@OneToMany(mappedBy = "course")
	private Collection<DrawingCategory> drawingCategories;
	
	@OneToMany(mappedBy = "course")
	private Collection<Unit> units;
			
	@OneToMany(mappedBy = "course")
	private Collection<Purchase> purchases;
	
	@OneToMany(mappedBy = "course")
	private Collection<CourseImage> courseImages;
}
