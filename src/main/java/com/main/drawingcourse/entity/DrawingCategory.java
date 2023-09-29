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
@Table(name = "DrawingCategories")
public class DrawingCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int drawCategoryId;
	
	@Column
	private String drawCategoryName;
	
	@ManyToMany(mappedBy = "drawingCategories")
	private Collection<Course> courses;

}
