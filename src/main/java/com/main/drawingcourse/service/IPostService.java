package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.PostModel;
import java.util.List;

public interface IPostService {
    PostModel AddPost(PostModel postModel);
    List<PostModel> findAll();

    void deleteByPostId(int id);


}
