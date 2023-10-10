package com.main.drawingcourse.entity;

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
@Table(name = "PostCategories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postCategoryId;
	
	@Column(columnDefinition = "nvarchar(20) not null")
	private String postCategoryName;
	
	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;

}
