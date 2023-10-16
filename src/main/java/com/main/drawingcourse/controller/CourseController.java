package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.DrawingCategory;
import com.main.drawingcourse.entity.Level;
import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.service.ICourseService;
import com.main.drawingcourse.service.ILevelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/find-by-InstructorId/{id}")
    public List<CourseModel> findCourseByIntructorID(@PathVariable("id") int id){
        return CourseService.findCourseByInstructorID(id);
        }

    @GetMapping("/view")

    public List<CourseModel> findAll() {
        return CourseService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourseById(@PathVariable int id) {

        CourseService.DeleteCoursebyid(id);
    }

    @PutMapping("edit/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody CourseModel courseModel) {
        CourseModel courseModel1 = CourseService.GetCoursebyid(id);
        if(courseModel!=null){
            courseModel1.setTitle(courseModel.getTitle());
            courseModel1.setCourseImage(courseModel.getCourseImage());
            courseModel1.setDescription(courseModel.getDescription());
            courseModel1.setPrice(courseModel.getPrice());
            courseModel1.setRating(courseModel.getRating());
            courseModel1.setProgress(courseModel.getProgress());
            courseModel1.setLevelId(courseModel.getLevelId());
            courseModel1.setDrawCategoryId(courseModel.getDrawCategoryId());
            courseModel1.setInstructorId(courseModel.getInstructorId());
            CourseService.UpdateCourse( courseModel1);
        }

        // You can return a response as needed
    }


    }









