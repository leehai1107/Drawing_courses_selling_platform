package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.ResponseCourse;
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


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<ResponseCourse> findByCourseName(@RequestParam("title") String title) {
        return CourseService.findByCourseTitle(title);
    }


    @GetMapping("/view")

    public List<ResponseCourse> findAll() {


        return CourseService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourseById(@PathVariable int id) {

        CourseService.DeleteCoursebyid(id);
    }

    @PutMapping("/edit/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody CourseModel courseModel) {
        CourseModel courseModel1 = CourseService.GetCoursebyid(id);
        if (courseModel != null) {
            courseModel1.setTitle(courseModel.getTitle());
            courseModel1.setDescription(courseModel.getDescription());
            courseModel1.setPrice(courseModel.getPrice());
            courseModel1.setRating(courseModel.getRating());
            courseModel1.setLevelId(courseModel.getLevelId());
            courseModel1.setDrawCategoryId(courseModel.getDrawCategoryId());
            courseModel1.setInstructorId(courseModel.getInstructorId());
            courseModel1.setStatus(courseModel1.isStatus());
            // Update the courseImage if it's not null in CourseModel
            if (courseModel.getCourseImage() != null) {
                courseModel1.setCourseImage(courseModel.getCourseImage());
            }

            CourseService.UpdateCourse(courseModel1);
        }
    }

    @GetMapping(value = "/find-Course-By-PriceRange/{start_price}/{end_price}")
    public List<ResponseCourse> findCourseByPriceRange(@PathVariable("start_price") double start_price, @PathVariable("end_price") double end_price ){
        return CourseService.findCoursesByPriceRange(start_price, end_price);
    }

    @GetMapping(value = "/find-Course-Has-Order")
    public List<ResponseCourse> findAllCourseHasOrder(@RequestParam("name") String name){
        return CourseService.findAllCourseHasOrder(name);
    }

    @GetMapping("/find-by-InstructorId/{id}")
    public List<ResponseCourse> getCoursesByInstructorId(@PathVariable int id) {
        return CourseService.findCourseByInstructorID(id);
    }

    @GetMapping(value = "/find-Course-Of-Instructor-By-UserName")
    public List<ResponseCourse> findAllCourseOfInstructorByUserName(@RequestParam("name") String name) {
        return CourseService.findAllCourseOfInstructorByUserName(name);
    }

    @GetMapping(value = "/find-Top4-Best-Seller-Course")
    public List<ResponseCourse> findTop4BestSellerCourse(){
        return CourseService.findTop4BestSellerCourse();
    }


    @GetMapping("/coursestatustrue")

    public List<ResponseCourse> viewcoursehasstatustrue(boolean status) {

        return CourseService.viewcoursehasstatustrue(status);
    }
    
    @GetMapping("/find/{id}")
    public CourseModel findCourseById (@PathVariable int id) {
    	return CourseService.GetCoursebyid(id);
    }


    @PutMapping("/update-status/{id}")
    public ResponseEntity<String> updateStatusOfCourseById(@PathVariable("id") int id) {
        String result = CourseService.UpdateStatusOfCourse(id);
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










