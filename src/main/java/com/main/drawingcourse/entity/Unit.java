package com.main.drawingcourse.entity;

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

@Entity
@Table(name = "Units")
public class Unit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int unitId;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	private String title;
	
	@Column(columnDefinition = "nvarchar(MAX) not null")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;
	
	@OneToMany(mappedBy = "unit")
	private Collection<Lesson> lessons;
}
