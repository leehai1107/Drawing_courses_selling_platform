package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD

@RestController
@RequestMapping("course")
=======

import java.util.List;

@RestController
@RequestMapping("public/course")
>>>>>>> new/main
public class CourseController {
    @Autowired
    ICourseService CourseService;

<<<<<<< HEAD
    @PostMapping(value = "/public/add")
    public CourseModel AddCourse(@RequestBody CourseModel courseModel) {
        return CourseService.AddCourse(courseModel);
    }
    @GetMapping(value = "/public/find-by-title")
    public CourseModel findByCourseName(@RequestParam("title") String title){
        return CourseService.findByCourseTitle(title);


=======
    @GetMapping(value = "/{id}")
    public CourseModel GetCoursebyid(@PathVariable int id){
        return  CourseService.GetCoursebyid(id);

    }

    @PostMapping(value = "/add")
    public CourseModel AddCourse(@RequestBody CourseModel courseModel) {
        return CourseService.AddCourse(courseModel);
    }

    @GetMapping("/view")

    public List<CourseModel> findAll() {
        return CourseService.findAll();
>>>>>>> new/main
    }
}

