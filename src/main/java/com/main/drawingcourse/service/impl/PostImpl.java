package com.main.drawingcourse.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.converter.PostConverter;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.dto.ResponsePostByCate;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;
import com.main.drawingcourse.repository.PostCategoryRepository;
import com.main.drawingcourse.repository.PostRepository;
import com.main.drawingcourse.service.IPostService;

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
        Post existingPost  = postRepository.findPostByTitle(postModel.getTitle());
        if(existingPost != null){
            throw new IllegalArgumentException("Post is already exists");
        }

        PostCategory postCategory = categoryRepository.findOneByPostCategoryId(postModel.getPostCategoryId());
        Post postEntity = postConverter.toEntity(postModel);
        postEntity.setPostCategory(postCategory);
        postEntity = postRepository.save(postEntity);

        return postConverter.toDto(postEntity);
    }

    public List<PostModel> findAll() {
        List<PostModel> Posts = postRepository.findAll().stream()
                .map(postConverter::toDto)
                .collect(Collectors.toList());

        return Posts;
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
    
    @Override
	public List<ResponsePostByCate> findPostByPostcategory(int id) {
        List<Post> postEntity = postRepository.findAllPostByPostCategoryID(id);
        List<ResponsePostByCate> postModels = postEntity.stream()
                .map(postConverter::toResponse)
                .collect(Collectors.toList());

        return postModels;

    }

}
