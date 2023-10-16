package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseModel {
    private int courseId;
    private String title;
    private String description;
    private Double price;
    private Integer rating;
    private int levelId;
    private int drawCategoryId;

    private int instructorId;

}
