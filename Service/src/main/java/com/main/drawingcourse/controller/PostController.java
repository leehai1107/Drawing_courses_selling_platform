package com.main.drawingcourse.controller;


import java.util.List;

import com.main.drawingcourse.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/poststatustrue")
    public List<ResponsePostByCate> viewpostbystatustrue(boolean status) {
        return postService.viewpostbystatustrue(status);
    }

    @GetMapping("/viewallpost")
    public List<ResponsePostByCate> getAllPosts() {

        return postService.getAllPosts();
    }



    @DeleteMapping(value = "/DeletePostById/{id}")
    public void deltePostById(@PathVariable int id){
        this.postService.deleteByPostId(id);


        }

        @GetMapping(value =  "find-Post-By-id/{id}")
        public List<ResponsePostByCate> findPostByID(@PathVariable int id){
        return postService.findPostByID(id);
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

    @PutMapping("/update-status/{id}")
    public ResponseEntity<String> updateStatusOfCourseById(@PathVariable("id") int id) {
        String result = postService.UpdatePostStatus(id);
        if (result.equals("Successfully changed the course status")) {
            return ResponseEntity.ok(result);
        } else if (result.equals("The course status is already true")) {
            return ResponseEntity.badRequest().body(result);
        }else if(result.equals("No course found")){
            return ResponseEntity.badRequest().body(result);
        }
        return null;
    }

}

