package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import org.springframework.stereotype.Repository;


@Repository

public interface CourseRepository extends JpaRepository<Course, Integer> {
//    void createCourse(int courseID,
//     String title,
//     String description,
//     Double price,
//     Integer rating,
//     Float progress,
//     int levelId,
//     int drawCategoryId,
//     int instructorId,
//     int orderId);

    Course findCourseByDescription(String title);

    @Query(
            value = "SELECT * FROM COURSES c WHERE c.title = :title",
            nativeQuery = true)
    Course findAllCoursesByTitle(@Param("title") String title);

    Course findCourseByCourseId(int id);


}
