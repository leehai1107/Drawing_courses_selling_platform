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


    Course findCourseByDescription(String title);

    @Query(
            value = "SELECT * FROM COURSES c WHERE c.title = :title",
            nativeQuery = true)
    Course findAllCoursesByTitle(@Param("title") String title);

    @Query(
            value = "SELECT * FROM COURSES c WHERE c.instructor_id = :id",
            nativeQuery = true)
    List<Course> findAllCoursesByInstructorId(@Param("id") int id);



}
