package com.main.drawingcourse.service;

import java.util.List;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.dto.ResponsePostByCate;

public interface IPostService {
	PostModel AddPost(PostModel postModel);

	List<ResponsePostByCate> findPostByID(int id);

	void deleteByPostId(int id);

	List<PostModel> findPostByPostcategoryId(int id);

	List<ResponsePostByCate> findPostByPostcategory(int id);

	List<ResponsePostByCate> getAllPosts();

	List<ResponsePostByCate> viewpostbystatustrue(boolean status);

	String UpdatePostStatus(int id);
}
