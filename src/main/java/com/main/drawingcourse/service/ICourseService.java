package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;

import java.util.List;

public interface ICourseService {
    CourseModel AddCourse(CourseModel courseModel);

    CourseModel findByCourseTitle(String title);


    CourseModel GetCoursebyid(int id);

    List<CourseModel> findAll();

    List<CourseModel> findCourseByInstructorID(int instructor_id);


    void DeleteCoursebyid (int id);

    void UpdateCourse(CourseModel CourseModel);

    Course findByCoursebyId(int id);

<<<<<<< HEAD
=======
    List<CourseModel> findCoursesByPriceRange(double start_price, double end_price);
>>>>>>> 0824267e742e2f035f44a358aa533ad88c0e7100


}
