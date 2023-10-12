package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.PostConverter;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.DrawingCategory;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;
import com.main.drawingcourse.repository.PostCategoryRepository;
import com.main.drawingcourse.repository.PostRepository;
import com.main.drawingcourse.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostImpl implements IPostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostCategoryRepository categoryRepository;

    @Autowired
    PostConverter postConverter;
    @Override
    public PostModel AddPost(PostModel postModel) {

        PostCategory postCategory = categoryRepository.findOneByPostCategoryId(postModel.getPostCategoryId());
        Post postEntity = postConverter.toEntity(postModel);
        postEntity.setPostCategory(postCategory);
        postEntity = postRepository.save(postEntity);

        return postConverter.toDto(postEntity);

    }
}
