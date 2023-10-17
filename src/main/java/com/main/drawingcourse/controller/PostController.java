package com.main.drawingcourse.controller;


import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.main.drawingcourse.converter.PostConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.repository.PostRepository;
import com.main.drawingcourse.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("public/post")
public class PostController {
    @Autowired

    IPostService postService;


    @PostMapping(value = "/add")
    public PostModel AddPost(@RequestBody PostModel postModel) {
        return postService.AddPost(postModel);


    }
//        @GetMapping(value = "/ViewAllPost")
//        public List<PostModel> findAll() {
//            return postService.findAll();
//        }


    @GetMapping("/viewallpost")
    public List<PostModel> getAllPosts() {
        return postService.getall(new PostModel());
    }

        @DeleteMapping(value = "/DeletePostById/{id}")
        public void deltePostById(@PathVariable int id){
            this.postService.deleteByPostId(id);


        }

    @GetMapping(value = "/find-post-by-category/{id}")
    public List<PostModel> findPostBycategoryID(@PathVariable int id){
        return postService.findPostByPostcategoryId(id);

    }

}

