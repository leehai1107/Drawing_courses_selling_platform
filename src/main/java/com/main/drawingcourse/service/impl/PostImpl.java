package com.main.drawingcourse.service.impl;


import com.main.drawingcourse.converter.PostConverter;


import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;
import com.main.drawingcourse.repository.PostCategoryRepository;

import com.main.drawingcourse.repository.PostRepository;
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.main.drawingcourse.dto.ResponsePostByCate;

@Service
public class PostImpl implements IPostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostCategoryRepository categoryRepository;

    @Autowired
    PostConverter postConverter;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostCategoryRepository postCategoryRepository;

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

    @Override
    public List<ResponsePostByCate> findPostByID(int id) {
        List<Post> postEntity = postRepository.findPostByPostId(id);
        List<ResponsePostByCate> postModels = postEntity.stream()
                .map(postConverter::toResponse)
                .collect(Collectors.toList());

        return postModels;

    }

    public List<ResponsePostByCate> getAllPosts() {
        List<ResponsePostByCate> postModels = postRepository.findAll().stream()
                .map(postConverter::toResponse)
                .collect(Collectors.toList());

        return postModels;
    }

//    @Override
//    public List<PostModel> getall(PostModel postModel) {
//        return null;
//    }

//    @Override
//    public List<PostModel> getallpost() {
//        List<Post> posts = postRepository.findAllPostsWithUserInfoAndCategory();
//        return posts.stream()
//                .map(postConverter::toDto)
//                .collect(Collectors.toList());
//    }


//    @Override
//    public List<PostModel> getall(PostModel postModel) {
//        List<Object[]> postData = postRepository.findAllPostsWithUserInfoAndCategory();
//
//        // Map the result to DTOs
//        return postData.stream()
//                .map(this::mapToPostModel)
//                .collect(Collectors.toList());
//
//    }



//    private PostModel mapToPostModel(Object[] data) {
//        PostModel postModel = new PostModel();
//        postModel.setPostId((Integer) data[0]);
//        postModel.setTitle((String) data[1]);
//        // Set other properties here based on the data array
//
//        return postModel;
//    }


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

    public List<ResponsePostByCate> viewpostbystatustrue(boolean status){
        List<ResponsePostByCate> postModels = postRepository.viewpostbystatustrue(status).stream()
                .map(postConverter::toResponse)
                .collect(Collectors.toList());
        return postModels;
    }

//    public List<ResponsePostByCate> getAllPosts() {
//        List<ResponsePostByCate> postModels = postRepository.findAll().stream()
//                .map(postConverter::toResponse)
//                .collect(Collectors.toList());
//
//        return postModels;
//    }
    
    @Override
	public List<ResponsePostByCate> findPostByPostcategory(int id) {
        List<Post> postEntity = postRepository.findAllPostByPostCategoryID(id);
        List<ResponsePostByCate> postModels = postEntity.stream()
                .map(postConverter::toResponse)
                .collect(Collectors.toList());

        return postModels;

    }

}
