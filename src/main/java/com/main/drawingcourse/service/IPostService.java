package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.dto.ResponsePostByCate;


import java.util.List;

public  interface IPostService {
    PostModel AddPost(PostModel postModel);

//    List<PostModel> getall (PostModel postModel);

//    List<PostModel> getallpost();


    void deleteByPostId(int id);


    List<PostModel> findPostByPostcategoryId(int id);
	List<ResponsePostByCate> findPostByPostcategory(int id);

    List<ResponsePostByCate> getAllPosts();
}
