package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
=======
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/course")
>>>>>>> update/main
public class CourseController {
    @Autowired
    ICourseService CourseService;

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
    }
}

