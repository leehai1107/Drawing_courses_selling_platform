package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.DrawingCateforyConverter;
import com.main.drawingcourse.dto.DrawingCategoryModel;
import com.main.drawingcourse.entity.DrawingCategory;
import com.main.drawingcourse.repository.DrawingCategoryRepository;
import com.main.drawingcourse.service.IDrawingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

public class DrawingCategoryImpl implements IDrawingCategoryService{
    @Autowired
    DrawingCategoryRepository categoryRepository;

    @Autowired
    DrawingCateforyConverter drawingCateforyConverter;
@Override
    public DrawingCategoryModel AddCategory(DrawingCategoryModel categoryModel){
        DrawingCategory existingCate = categoryRepository.findByDrawCategoryName(categoryModel.getDrawCategoryName());
        if(existingCate != null){
            throw new IllegalArgumentException("Drawing Category is already exists");

        }

             DrawingCategory categoryEntity = drawingCateforyConverter.toEntity(categoryModel);
             categoryEntity = categoryRepository.save(categoryEntity);

    return drawingCateforyConverter.toDto(categoryEntity);
}


    public List<DrawingCategoryModel> findAll() {
        List<DrawingCategoryModel> drawingCategories =  categoryRepository.findAll().stream()
                .map(drawingCateforyConverter::toDto)
                .collect(Collectors.toList());

        return drawingCategories;
    }

}
