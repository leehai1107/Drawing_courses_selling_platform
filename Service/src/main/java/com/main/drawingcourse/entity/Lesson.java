package com.main.drawingcourse.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lessons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lessonId;

	@Column(columnDefinition = "nvarchar(50) not null")
	private String title;

	@Column(columnDefinition = "nvarchar(MAX) not null")
	private String content;

	@Column(columnDefinition = "nvarchar(MAX) not null")
	private String videoUrl;

	@Column
	private LocalTime videoDuration;

	@Column
	private Boolean lessonStatus;

	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

}
