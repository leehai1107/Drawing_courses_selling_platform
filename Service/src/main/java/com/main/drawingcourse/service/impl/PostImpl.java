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
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.IPostService;

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
		Post existingPost = postRepository.findPostByTitle(postModel.getTitle());
		if (existingPost != null) {
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
		List<ResponsePostByCate> postModels = postEntity.stream().map(postConverter::toResponse)
				.collect(Collectors.toList());

		return postModels;

	}

	@Override
	public List<ResponsePostByCate> getAllPosts() {
		List<ResponsePostByCate> postModels = postRepository.findAll().stream().map(postConverter::toResponse)
				.collect(Collectors.toList());

		return postModels;
	}

	@Override

	public void deleteByPostId(int id) {
		this.postRepository.deleteByPostId(id);

	}

	@Override
	public List<PostModel> findPostByPostcategoryId(int id) {
		List<Post> postEntity = postRepository.findAllPostByPostCategoryID(id);
		List<PostModel> postModels = postEntity.stream().map(postConverter::toDto).collect(Collectors.toList());

		return postModels;

	}

	@Override
	public List<ResponsePostByCate> viewpostbystatustrue(boolean status) {
		List<ResponsePostByCate> postModels = postRepository.viewpostbystatustrue(status).stream()
				.map(postConverter::toResponse).collect(Collectors.toList());
		return postModels;
	}

	@Override
	public String UpdatePostStatus(int id) {
		Post post = postRepository.findPostByID(id);

		if (post != null) {
			if (post.isStatus()) {
				return "The course status is already true";
			} else {
				post.setStatus(true);
				postRepository.save(post);
				return "Successfully changed the course status";
			}
		}

		return "No course found";
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
		List<ResponsePostByCate> postModels = postEntity.stream().map(postConverter::toResponse)
				.collect(Collectors.toList());

		return postModels;

	}

}
