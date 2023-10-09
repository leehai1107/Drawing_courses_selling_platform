package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.DrawingCategoryModel;
import com.main.drawingcourse.entity.DrawingCategory;

public interface IDrawingCategoryService {
    DrawingCategoryModel AddCategory(DrawingCategoryModel categoryModel);
}
