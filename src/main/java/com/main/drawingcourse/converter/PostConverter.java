package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.dto.ResponsePostByCate;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.repository.PostCategoryRepository;
import com.main.drawingcourse.repository.PostRepository;
import com.main.drawingcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Post;

import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostCategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostCategoryConverter postConverter;
    @Autowired
    UserConverter userConverter;
    public Post toEntity(PostModel postModel) {
        Post entity = new Post();

        entity.setPostId(postModel.getPostId());
        entity.setTitle(postModel.getTitle());
        entity.setContent(postModel.getContent());
        entity.setPostDate(postModel.getPostDate());
        entity.setPostCategory(categoryRepository.getReferenceById(postModel.getPostCategoryId()));
        entity.setUser(userRepository.getReferenceById(postModel.getUserId()));
        entity.setPostImage(postModel.getPostImage());
        entity.setStatus(postModel.isStatus());
        return entity;
    }

    public PostModel toDto(Post post) {
        PostModel dto = new PostModel();

        dto.setPostId(post.getPostId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setPostDate(post.getPostDate());
        dto.setPostCategoryId(post.getPostCategory().getPostCategoryId());
        dto.setUserId(post.getUser().getUserId());
        dto.setPostImage(post.getPostImage());
        dto.setStatus(post.isStatus());

        return dto;
    }

    public ResponsePostByCate toResponse(Post post) {
    	ResponsePostByCate dto = new ResponsePostByCate();

        dto.setPostId(post.getPostId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setPostDate(post.getPostDate());
        dto.setStatus(post.isStatus());
        dto.setCateInfo(postConverter.toDto(post.getPostCategory()));
        dto.setUserInfo(userConverter.toResponse(post.getUser()));

        dto.setPostImage(post.getPostImage());
        return dto;
    }


}
