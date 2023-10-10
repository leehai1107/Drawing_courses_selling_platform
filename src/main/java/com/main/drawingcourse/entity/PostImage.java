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
@Table(name = "PostImages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageId;
	@Column(columnDefinition = "nvarchar(MAX) not null")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;

}
