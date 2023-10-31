package com.main.drawingcourse.converter;

import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.DrawingCategoryModel;
import com.main.drawingcourse.entity.DrawingCategory;

@Component
public class DrawingCateforyConverter {

	public DrawingCategory toEntity(DrawingCategoryModel categoryModel) {
		DrawingCategory entity = new DrawingCategory();
		entity.setDrawCategoryId(categoryModel.getDrawCategoryId());
		entity.setDrawCategoryName(categoryModel.getDrawCategoryName());
		return entity;
	}

	public DrawingCategoryModel toDto(DrawingCategory categoryEnitity) {
		DrawingCategoryModel dto = new DrawingCategoryModel();
		dto.setDrawCategoryId(categoryEnitity.getDrawCategoryId());
		dto.setDrawCategoryName(categoryEnitity.getDrawCategoryName());
		return dto;
	}
}
