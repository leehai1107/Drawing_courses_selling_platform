package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.PostCategoryModel;
import com.main.drawingcourse.entity.PostCategory;

public interface IPostCategory {
    PostCategoryModel addPostCategory(PostCategoryModel postCategoryModel);
}
