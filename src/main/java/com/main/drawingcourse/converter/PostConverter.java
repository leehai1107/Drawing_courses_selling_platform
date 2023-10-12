package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.repository.PostCategoryRepository;
import com.main.drawingcourse.repository.PostRepository;
import com.main.drawingcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostCategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;
    public Post toEntity(PostModel postModel) {
        Post entity = new Post();

        entity.setPostId(postModel.getPostId());
        entity.setTitle(postModel.getTitle());
        entity.setContent(postModel.getContent());
        entity.setPostDate(postModel.getPostDate());
        entity.setPostCategory(categoryRepository.getReferenceById(postModel.getPostCategoryId()));
        entity.setUser(userRepository.getReferenceById(postModel.getUserId()));
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
        return dto;
    }



}
