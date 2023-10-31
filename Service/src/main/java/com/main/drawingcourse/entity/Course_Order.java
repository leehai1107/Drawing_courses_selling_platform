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
@Table(name = "Course_Order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course_Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	@Column
	private int rating;

	@Column(columnDefinition = "DATE")
	LocalDate registeredAt;

	@Column
	private float progress;

	@OneToMany(mappedBy = "course_Order")
	private Collection<Review> reviews;

}
