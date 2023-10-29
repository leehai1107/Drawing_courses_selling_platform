package com.main.drawingcourse.entity;

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
@Table(name = "DrawingCategories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrawingCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int drawCategoryId;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	private String drawCategoryName;
	
	@OneToMany(mappedBy = "drawingCategory")
	private Collection<Course> courses;
}
