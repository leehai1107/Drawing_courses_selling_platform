package com.main.drawingcourse.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePostByCate {
	 private int postId;
	 private String title;
	 private String content;
	 private LocalDate postDate;
	 private boolean status;
	 private UserModelRespone userInfo;
	 private PostCategoryModel cateInfo;
	 private String postImage;
	 private boolean status;
}
