package com.main.drawingcourse.dto;

import com.main.drawingcourse.entity.DrawingCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCourse {
    private int courseid;
    private String description;
    private Double price;
    private String title;
    private int rating;
    private UserModelRespone userinfo;
    private LevelModel levelinfo;
    private DrawingCategoryModel CateInfo;
    private String courseImg;
}
