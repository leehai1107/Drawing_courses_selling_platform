package com.main.drawingcourse.entity;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Course_Level",
	joinColumns = @JoinColumn(name="courseId"),
	inverseJoinColumns = @JoinColumn(name="levelId"))
	private Collection<Level> levels;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Course_Category",
	joinColumns = @JoinColumn(name="courseId"),
	inverseJoinColumns = @JoinColumn(name="drawCategoryId"))
	private Collection<DrawingCategory> drawingCategories;
	
	@ManyToMany(mappedBy = "courses")
	private Collection<User> users;

	@OneToMany(mappedBy = "course")
	private Collection<Unit> units;
	
	@OneToMany(mappedBy = "course")
	private Collection<CustomerCourse> customerCourses;
	
	@OneToMany(mappedBy = "course")
	private Collection<Review> reviews;
	
	@OneToMany(mappedBy = "course")
	private Collection<Purchase> purchases;
	
	@OneToMany(mappedBy = "course")
	private Collection<CourseImage> courseImages;
}
