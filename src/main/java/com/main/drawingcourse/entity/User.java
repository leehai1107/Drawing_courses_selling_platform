package com.main.drawingcourse.entity;



import java.time.LocalDate;
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
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique = true)
	private String userName;
	
	@Column
	private String password;
	
	@Column
	private String fullname;
	
	@Column
	private LocalDate dob;
	
	@Column
	private Boolean sex;
	@Column(columnDefinition = "nvarchar(MAX) not null")
	private String avatar;
	
	@Column(columnDefinition = "nvarchar(MAX) not null")
	private String description;
	
	@Column(unique = true)
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "User_Role",
	joinColumns = @JoinColumn(name="userId"),
	inverseJoinColumns = @JoinColumn(name="roleId"))
	private Collection<Role> roles;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Instructor_Course"
	,joinColumns = @JoinColumn(name="instructorId"),
	inverseJoinColumns = @JoinColumn(name="courseId"))
	private Collection<Course> courses;
	
	@OneToMany(mappedBy = "user")
	private Collection<DependencyUser> dependencyUsers;
	
	@OneToMany(mappedBy = "user")
	private Collection<Post> posts;
	
	@OneToMany(mappedBy = "user")
	private Collection<Review> reviews;
	
	@OneToMany(mappedBy = "user")
	private Collection<Purchase> purchases;
}
