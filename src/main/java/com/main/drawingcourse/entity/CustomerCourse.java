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
@Table(name = "CustomerCourses")
public class CustomerCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerCourseId;
	@Column
	private LocalDate enrollmentDate;
	@Column
	private float progress;
	@Column
	private float grade;
	@Column
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "learnerId")
	private DependencyUser dependencyUser;

}
