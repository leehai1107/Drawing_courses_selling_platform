package com.main.drawingcourse.entity;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@Column
	private String title;
	@Column(columnDefinition = "nvarchar(MAX) not null")
	private String content;
	@Column
	private LocalDate postDate;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToMany
	@JoinTable(name = "Post_Category",
	joinColumns = @JoinColumn(name="postId"),
	inverseJoinColumns = @JoinColumn(name="postCategoryId"))
	private Collection<PostCategory> postCategories;
	
	@OneToMany(mappedBy = "post")
	private Collection<PostImage> postImages;

}
