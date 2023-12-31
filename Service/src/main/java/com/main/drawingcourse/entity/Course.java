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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;

	@Column(columnDefinition = "nvarchar(50) not null")
	private String title;

	@Column(columnDefinition = "nvarchar(max) not null")
	private String description;

	@Column
	private Double price;

	@Column
	private Integer rating;

	@Column
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "instructorId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "levelId")
	private Level level;

	@ManyToOne
	@JoinColumn(name = "drawCategoryId")
	private DrawingCategory drawingCategory;

	@OneToMany(mappedBy = "course")
	private Collection<Lesson> lessons;

	@OneToMany(mappedBy = "course")
	private Collection<Course_Order> course_Orders;

	@Column(name = "CourseImage", columnDefinition = "varchar(max) not null")
	private String courseImage;

}
