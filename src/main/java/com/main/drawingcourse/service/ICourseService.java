package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.ResponseCourse;
import com.main.drawingcourse.entity.Course;

import java.util.List;

public interface ICourseService {
    CourseModel AddCourse(CourseModel courseModel);

    CourseModel findByCourseTitle(String title);

    CourseModel GetCoursebyid(int id);

    List<ResponseCourse> findAll();

    List<CourseModel> findCourseByInstructorID(int instructor_id);


    void DeleteCoursebyid (int id);

    void UpdateCourse(CourseModel CourseModel);
    void editCourse(int courseId, CourseModel courseModel);

    Course findByCoursebyId(int id);


	List<CourseModel> findCoursesByPriceRange(double start_price, double end_price);



    List<CourseModel> findAllCourseHasOrder(String name);

    List<CourseModel> findAllCourseOfInstructorByUserName(String name);

    List<CourseModel> findTop4BestSellerCourse();

}
