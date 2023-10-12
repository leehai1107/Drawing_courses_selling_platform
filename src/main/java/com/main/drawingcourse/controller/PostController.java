package com.main.drawingcourse.controller;

import com.main.drawingcourse.converter.PostConverter;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.repository.PostRepository;
import com.main.drawingcourse.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("public/post")
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    IPostService postService;

    @GetMapping("/ViewAllPost")

    public List<PostModel> findAll() {
        return postService.findAll();
    }
}
