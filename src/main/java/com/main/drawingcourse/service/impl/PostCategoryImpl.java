package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.PostCategoryConverter;
import com.main.drawingcourse.dto.PostCategoryModel;
import com.main.drawingcourse.entity.DrawingCategory;
import com.main.drawingcourse.entity.PostCategory;
import com.main.drawingcourse.repository.PostCategoryRepository;
import com.main.drawingcourse.service.IPostCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCategoryImpl implements IPostCategory {
    @Autowired
    PostCategoryRepository postCategoryRepository;
    @Autowired
    PostCategoryConverter postCategoryConverter;


    @Override
    public PostCategoryModel addPostCategory(PostCategoryModel postCategoryModel) {
        PostCategory categoryEntity = postCategoryConverter.toEntity(postCategoryModel);
        categoryEntity = postCategoryRepository.save(categoryEntity);

        return postCategoryConverter.toDto(categoryEntity);

    }
}
