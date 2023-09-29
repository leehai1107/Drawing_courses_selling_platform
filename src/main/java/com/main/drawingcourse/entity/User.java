package com.main.drawingcourse.entity;



import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToMany(mappedBy = "user")
	private Collection<Role> roles;
	
	@OneToMany(mappedBy = "user")
	private Collection<Course> course;
	
	@OneToMany(mappedBy = "user")
	private Collection<DependencyUser> dependencyUsers;
	
	@OneToMany(mappedBy = "user")
	private Collection<Post> posts;
	
}
