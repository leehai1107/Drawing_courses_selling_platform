package com.main.drawingcourse.dto;

import com.main.drawingcourse.entity.DrawingCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCourse {
    private int courseId;
    private String courseImage;
    private String description;
    private Double price;
    private String title;
    private int rating;
    private boolean status;
    private int drawCategoryId;
    private DrawingCategoryModel drawingCategoryModel;
    private int levelId;
    private LevelModel levelModel;
    private int instructorId;
    private UserModelRespone userModelRespone;
    private int lession_count = 0 ;




}
