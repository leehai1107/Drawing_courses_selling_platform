package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostModel {

    private int postId;
    private String title;
    private String content;
    private LocalDate postDate;
    private int userId;
    private int postCategoryId;
    private String postimage;
    private String postImage;

}
