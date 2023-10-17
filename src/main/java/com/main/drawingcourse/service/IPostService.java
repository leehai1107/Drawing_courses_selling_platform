package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.PostModel;

import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;


import java.util.List;

public  interface IPostService {
    PostModel AddPost(PostModel postModel);

    List<PostModel> getall (PostModel postModel);


    void deleteByPostId(int id);


    List<PostModel> findPostByPostcategoryId(int id);

}
