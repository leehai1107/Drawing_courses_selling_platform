package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.PostModel;

import java.util.List;

public interface IPostService {

    List<PostModel> findAll();
}
