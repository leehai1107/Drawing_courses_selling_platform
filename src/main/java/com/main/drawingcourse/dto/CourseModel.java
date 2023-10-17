package com.main.drawingcourse.dto;

import com.main.drawingcourse.entity.DrawingCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseModel {
//    private List<DrawingCategoryModel> drawingCategoryModels;
//    private List<LevelModel> levelModels;
//    private List<UserModel> userModels;
    private int courseId;
    private String courseImage;
    private String title;
    private String description;
    private Double price;
    private Integer rating;
    private int levelId;
    private int drawCategoryId;
    private int instructorId;
    private String levelName;
    private String drawCategoryName;
    private String instructorName;

    public static void setinstructorName(String fullname) {
    }

    public static void setlevelName(String levelName) {
    }

    public static void setdrawCategoryName(String drawCategoryName) {
    }


//    public void DrawingCategory(List<DrawingCategoryModel> drawingCategoryModels) {
//        this.drawingCategoryModels = drawingCategoryModels;
//    }
//    public void level(List<LevelModel> levelModels) {
//        this.levelModels = levelModels;
//    }
//
//    public void User(List<UserModel> userModels) {
//        this.userModels = userModels;
//    }



}
