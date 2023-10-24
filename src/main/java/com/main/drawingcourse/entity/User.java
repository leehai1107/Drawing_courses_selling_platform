package com.main.drawingcourse.entity;

import java.time.LocalDate;
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
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique = true,columnDefinition = "varchar(50)")
	private String userName;
	
	@Column(unique = true,columnDefinition = "varchar(50)")
	private String email;
	
	@Column
	private String password;
	
	@Column(columnDefinition = "varchar(50)")
	private String fullname;
	
	@Column(unique = true,columnDefinition = "varchar(50)")
	private String phone;
	
	@Column
	private LocalDate dob;
	
	@Column
	private Boolean sex;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String avatar;
	
	@Column(columnDefinition = "nvarchar(MAX) ")
	private String description;
	
	@Column
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;
	
	@OneToMany(mappedBy = "user")
	private Collection<Course> course;
	
	@OneToMany(mappedBy = "user")
	private Collection<Order> oders;
	
	@OneToMany(mappedBy = "user")
	private Collection<Post> posts;
	
}
