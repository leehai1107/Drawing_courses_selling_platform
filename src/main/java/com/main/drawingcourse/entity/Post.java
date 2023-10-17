package com.main.drawingcourse.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Posts")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@Column(columnDefinition = "nvarchar(50) not null")
	private String title;
	@Column(columnDefinition = "nvarchar(max) not null")
	private String content;
	@Column(columnDefinition = "DATE")
	private LocalDate postDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="postCategoryId")
	private PostCategory postCategory;
	
	@Column(columnDefinition = "nvarchar(500) not null")
	private String postImage;


}
