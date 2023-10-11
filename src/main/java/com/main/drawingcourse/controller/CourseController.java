package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("public/course")
public class CourseController {
    @Autowired
    ICourseService CourseService;


    @PostMapping(value = "/add")
    public CourseModel AddCourse(@RequestBody CourseModel courseModel) {
        return CourseService.AddCourse(courseModel);
    }

    @GetMapping(value = "/find-by-title")
    public CourseModel findByCourseName(@RequestParam("title") String title) {
        return CourseService.findByCourseTitle(title);



    }
}

