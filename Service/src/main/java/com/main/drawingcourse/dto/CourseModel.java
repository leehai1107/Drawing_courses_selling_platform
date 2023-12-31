package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseModel {
	private int courseId;
	private String courseImage;
	private String title;
	private String description;
	private Double price;
	private int rating;
	private int drawCategoryId;
	private DrawingCategoryModel drawingCategoryModel;
	private int levelId;
	private LevelModel levelModel;
	private int instructorId;
	private UserModelRespone userModelRespone;
	private boolean status;

}
