package com.main.drawingcourse.dto;

import com.main.drawingcourse.entity.DrawingCategory;
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
    private Integer rating;
    private int levelId;
    private DrawingCategory drawingCategory;
    private int drawCategoryId;
    private int instructorId;

}
