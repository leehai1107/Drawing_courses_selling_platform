package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.PostCategoryModel;
import com.main.drawingcourse.service.IPostCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("public/postCategory")
public class PostCategoryController {
    @Autowired
    IPostCategory postCategory;

    @PostMapping (value = "/addPostCategory")
    public PostCategoryModel addPostCategory(@RequestBody PostCategoryModel postCategoryModel){
        return postCategory.addPostCategory(postCategoryModel);
    }
}
