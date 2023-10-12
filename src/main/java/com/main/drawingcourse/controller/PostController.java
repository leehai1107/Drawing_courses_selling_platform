package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/post")
public class PostController {
    @Autowired
    IPostService postService;

    @PostMapping(value = "/add")
    public PostModel AddPost(@RequestBody PostModel postModel){
        return postService.AddPost(postModel);
    }
}
