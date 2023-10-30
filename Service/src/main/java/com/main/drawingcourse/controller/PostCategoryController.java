package com.main.drawingcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.dto.PostCategoryModel;
import com.main.drawingcourse.service.IPostCategory;

@RestController
@RequestMapping("public/postCategory")
public class PostCategoryController {
	@Autowired
	IPostCategory postCategory;

	@PostMapping(value = "/addPostCategory")
	public PostCategoryModel addPostCategory(@RequestBody PostCategoryModel postCategoryModel) {
		return postCategory.addPostCategory(postCategoryModel);
	}
}
