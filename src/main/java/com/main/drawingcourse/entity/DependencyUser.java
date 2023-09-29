package com.main.drawingcourse.entity;

import java.util.Collection;
import java.util.Date;

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
@Table(name = "DependencyUsers")
public class DependencyUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dependencyUserId;
	
	@Column
	private String fullname;
	
	@Column
	private Boolean sex;
	
	@Column
	private Date dob;
	
	@ManyToOne
	@JoinColumn(name = "parentId")
	private User user;
	
	@OneToMany(mappedBy = "dependencyUser")
	private Collection<CustomerCourse> customerCourses;
}
