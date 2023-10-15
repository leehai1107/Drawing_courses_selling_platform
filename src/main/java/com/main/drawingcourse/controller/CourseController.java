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


    @PostMapping(value = "/addCourse")
    public CourseModel AddCourse(@RequestBody CourseModel courseModel) {
        return CourseService.AddCourse(courseModel);
    }

    @GetMapping(value = "/find-by-title")
    public CourseModel findByCourseName(@RequestParam("title") String title) {
        return CourseService.findByCourseTitle(title);
    }

    @GetMapping(value = "/find-by-InstructorId/{id}")
    public List<CourseModel> findCourseByIntructorID(@PathVariable("id") int id){
        return CourseService.findCourseByInstructorID(id);
        }

    @GetMapping("/view")
    public List<CourseModel> findAll() {
        return CourseService.findAll();
    }


    @GetMapping(value = "/find-Course-By-PriceRange/{start_price}/{end_price}")
    public List<CourseModel> findCourseByIntructorID(@PathVariable("start_price") Double start_price, @PathVariable("end_price") Double end_price){
        return CourseService.findCoursesByPriceRange(start_price,end_price);
    }

    @GetMapping(value = "/find-Course-Has-Order")
    public List<CourseModel> findAllCourseHasOrder(){
        return CourseService.findAllCourseHasOrder();
    }




}
