package com.main.drawingcourse.service;

import java.util.List;

import com.main.drawingcourse.dto.DrawingCategoryModel;

public interface IDrawingCategoryService {
	DrawingCategoryModel AddCategory(DrawingCategoryModel categoryModel);

	List<DrawingCategoryModel> findAll();

}
