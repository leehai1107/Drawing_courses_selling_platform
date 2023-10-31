package com.main.drawingcourse.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostModel {

	private int postId;
	private String title;
	private String content;
	private LocalDate postDate;
	private boolean status;
	private int userId;
	private int postCategoryId;
	private String postImage;

}
