package com.main.drawingcourse.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.dto.ResponsePostByCate;
import com.main.drawingcourse.service.IPostService;


@RestController
@RequestMapping("public/post")
public class PostController {
    @Autowired
    IPostService postService;

    @Autowired
    PostRepository postRepository;

    @PostMapping(value = "/add")
    public PostModel AddPost(@RequestBody PostModel postModel) {
        return postService.AddPost(postModel);


    }
//        @GetMapping(value = "/ViewAllPost")
//        public List<PostModel> findAll() {
//            return postService.findAll();
//        }


    @GetMapping("/viewallpost")
    public ResponseEntity<List<PostModel>> getAllPosts() {
        List<PostModel> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @DeleteMapping(value = "/DeletePostById/{id}")
    public void deltePostById(@PathVariable int id){
        this.postService.deleteByPostId(id);


        }

//        remove later
    @GetMapping(value = "/find-post-by-category/{id}")
    public List<PostModel> findPostBycategoryID(@PathVariable int id){
        return postService.findPostByPostcategoryId(id);

    }
    
    @GetMapping(value = "/find/{id}")
    public List<ResponsePostByCate> findPostBycategory(@PathVariable int id){
        return postService.findPostByPostcategory(id);

    }

}

