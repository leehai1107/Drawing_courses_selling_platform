package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository

public interface CourseRepository extends JpaRepository<Course, Integer> {




    Course findCourseByTitle(String title);

    @Query(
            value = "SELECT * FROM COURSES c WHERE c.title = :title",
            nativeQuery = true)
    Course findCoursesByTitle(@Param("title") String title);

    @Query(
            value = "SELECT * FROM COURSES c WHERE c.instructor_id = :id",
            nativeQuery = true)
    List<Course> findAllCoursesByInstructorId(@Param("id") int id);


    @Query(
            value = "SELECT * FROM COURSES c WHERE c.price BETWEEN :start_price AND :end_price",
            nativeQuery = true)
    List<Course> findCoursesByPriceRange(@Param("start_price") double start_price, @Param("end_price") double end_price);

}
