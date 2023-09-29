package com.main.drawingcourse.entity;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PostCategories")
public class PostCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postCategoryId;
	@Column
	private String postCategoryName;
	
	@ManyToMany(mappedBy = "postCategories")
	private Collection<Post> posts;

}
