package com.main.drawingcourse.entity;

import java.time.LocalDate;

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
@Table(name = "Posts")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String title;
	@Column(columnDefinition = "nvarchar(max) not null")
	private String content;
	@Column(columnDefinition = "DATE")
	private LocalDate postDate;

	@Column
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "postCategoryId")
	private PostCategory postCategory;

	@Column(columnDefinition = "varchar(max) not null")
	private String postImage;

}
