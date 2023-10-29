package com.main.drawingcourse.dto;

import com.main.drawingcourse.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCategoryModel {
    private int postCategoryId;
    private String postCategoryName;

}
