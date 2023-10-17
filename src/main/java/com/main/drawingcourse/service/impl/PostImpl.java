package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.PostConverter;


import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.DrawingCategory;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;
import com.main.drawingcourse.repository.PostCategoryRepository;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.LevelModel;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;

import com.main.drawingcourse.repository.PostRepository;
import com.main.drawingcourse.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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



    @Override
    public List<PostModel> getall(PostModel postModel) {
        List<Object[]> postData = postRepository.findAllPostsWithUserInfoAndCategory();

        // Map the result to DTOs
        return postData.stream()
                .map(this::mapToPostModel)
                .collect(Collectors.toList());

    }

    private PostModel mapToPostModel(Object[] data) {
        PostModel postModel = new PostModel();
        postModel.setPostId((Integer) data[0]);
        postModel.setTitle((String) data[1]);
        // Set other properties here based on the data array

        return postModel;
    }


    @Override

    public void deleteByPostId(int id) {
     this.postRepository.deleteByPostId(id);

    }


    public List<PostModel> findPostByPostcategoryId(int id) {
        List<Post> postEntity = postRepository.findAllPostByPostCategoryID(id);
        List<PostModel> postModels = postEntity.stream()
                .map(postConverter::toDto)
                .collect(Collectors.toList());

        return postModels;

    }

}
