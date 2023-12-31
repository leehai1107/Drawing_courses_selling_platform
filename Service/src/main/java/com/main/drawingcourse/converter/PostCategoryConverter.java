package com.main.drawingcourse.converter;

import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.PostCategoryModel;
import com.main.drawingcourse.entity.PostCategory;

@Component
public class PostCategoryConverter {
	public PostCategory toEntity(PostCategoryModel postCategoryModel) {
		PostCategory entity = new PostCategory();
		entity.setPostCategoryId(postCategoryModel.getPostCategoryId());
		entity.setPostCategoryName(postCategoryModel.getPostCategoryName());
		return entity;

	}

	public PostCategoryModel toDto(PostCategory postCategory) {
		PostCategoryModel dto = new PostCategoryModel();
		dto.setPostCategoryId(postCategory.getPostCategoryId());
		dto.setPostCategoryName(postCategory.getPostCategoryName());

		return dto;
	}

}
