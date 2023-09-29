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
@Table(name = "Levels")
public class Level {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int levelId;
	
	@Column
	private String levelName;
	
	@ManyToMany(mappedBy = "levels")
	private Collection<Course> courses;
}
