package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    ICourseService CourseService;

    @PostMapping("/add")
    public CourseModel AddCourse(@RequestBody CourseModel courseModel) {

        return CourseService.AddCourse(courseModel);
    }
@GetMapping( "/view")
    public List<CourseModel> findAll() {
        return CourseService.findAll();
    }
}
