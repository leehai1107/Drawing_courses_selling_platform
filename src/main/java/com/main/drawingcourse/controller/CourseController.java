package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/course")
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

<<<<<<< HEAD

    @DeleteMapping(value = "/{id}")
    public void DeleteCoursebyid(@PathVariable int id) {
        CourseService.DeleteCoursebyid(id);
    }

=======
    @GetMapping("/view")

    public List<CourseModel> findAll() {
        return CourseService.findAll();
    }
>>>>>>> newup/main
}

