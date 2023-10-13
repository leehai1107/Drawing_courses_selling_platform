package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;

import java.util.List;

public interface IPostService {

    List<PostModel> findAll();
    List<PostModel> findPostByPostcategoryId(int id);
}
