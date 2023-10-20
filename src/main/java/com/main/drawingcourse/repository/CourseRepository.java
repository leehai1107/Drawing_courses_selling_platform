package com.main.drawingcourse.repository;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface CourseRepository extends JpaRepository<Course, Integer> {


    @Query(value = "SELECT courses.course_id, courses.course_image, courses.description, courses.price, courses.rating, courses.title, courses.instructor_id, drawing_categories.draw_category_id, drawing_categories.draw_category_name, levels.level_id, levels.level_name, users.user_id, users.fullname FROM courses JOIN drawing_categories ON courses.draw_category_id = drawing_categories.draw_category_id JOIN levels ON courses.level_id = levels.level_id JOIN users ON courses.instructor_id = users.user_id where instructor_id = :id", nativeQuery = true)
    List<Course> findAllCoursesByInstructorId(@Param("id") int id);


    @Query(
            value = "SELECT * FROM COURSES c WHERE c.title = :title AND c.instructor_id = :id",
            nativeQuery = true)
    Course findCoursesByTitleAndInstructorID(@Param("title") String title, @Param("id") int id);


    @Query(
            value = "SELECT * FROM COURSES c WHERE c.title = :title",
            nativeQuery = true
            )
    Course findCoursesByTitle(@Param("title") String title);

//    @Query(
//            value = "SELECT * FROM COURSES c WHERE c.instructor_id = :id",
//            nativeQuery = true)
//    List<Course> findAllCoursesByInstructorId(@Param("id") int id);


    @Query(
            value = "SELECT * FROM COURSES c WHERE c.price BETWEEN :start_price AND :end_price",
            nativeQuery = true)
    List<Course> findCoursesByPriceRange(@Param("start_price") double start_price, @Param("end_price") double end_price);



    @Query(
            value = "SELECT c.course_id, c.title, c.description, c.price, c.rating, c.course_image, c.draw_category_id, c.level_id, c.instructor_id FROM Courses c INNER JOIN Users u ON c.instructor_id = u.user_id WHERE c.course_id IN (SELECT course_id FROM course_order)AND u.user_name = :name",
            nativeQuery = true)
    List<Course> findAllCourseHasOrder(@Param("name") String name);

    @Query(
            value = "SELECT c.course_id, c.title, c.description, c.price, c.rating, c.course_image, c.draw_category_id, c.level_id, c.instructor_id FROM Courses c JOIN Users u ON c.instructor_id = u.user_id WHERE u.user_name = :name",
            nativeQuery = true)
    List<Course> findAllCourseOfInstructorByUserName(@Param("name") String name);


    @Query(value = "SELECT * FROM COURSES WHERE courseId = :id", nativeQuery = true)
    Course findCourseByID(@Param("id") int id);



    @Query(value = "SELECT TOP 4 c.course_id, c.title, c.description, c.price, c.rating, c.course_image, c.draw_category_id, c.level_id, c.instructor_id FROM Courses c JOIN course_order co ON c.course_id = co.course_id GROUP BY c.course_id, c.title, c.description, c.price, c.rating, c.course_image, c.draw_category_id, c.level_id, c.instructor_id ORDER BY COUNT(co.order_id) DESC", nativeQuery = true)
    List<Course> findTop4BestSellerCourse();



}
