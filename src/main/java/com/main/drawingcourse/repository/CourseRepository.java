package com.main.drawingcourse.repository;

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


    Course findCourseByDescription(String title);

    @Query(
            value = "SELECT * FROM COURSES c WHERE c.title = :title",
            nativeQuery = true)
    Course findAllCoursesByTitle(@Param("title") String title);

    @Query(
            value = "SELECT * FROM COURSES c WHERE c.instructor_id = :id",
            nativeQuery = true)
    List<Course> findAllCoursesByInstructorId(@Param("id") int id);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Courses AS c " +
            "SET c.title = :title, " +
            "    c.description = :description, " +
            "    c.price = :price, " +
            "    c.rating = :rating " +
            "FROM Courses AS c " +
            "WHERE " +
            "    c.course_id = :Courseid " +
            "    AND EXISTS (SELECT 1 FROM Levels AS l WHERE l.level_id = :levelId) " +
            "    AND EXISTS (SELECT 1 FROM DrawingCategories AS dc WHERE dc.draw_category_id = :drawCategoryId) " +
            "    AND EXISTS (SELECT 1 FROM Users AS i WHERE i.user_id = :instructorId)",
            nativeQuery = true)


    void editCourse(
            @Param("courseid") int Courseid,
            @Param("title") String title,
            @Param("description") String description,
            @Param("price") Double price,
            @Param("rating") int rating,
            @Param("levelId") int levelId,
            @Param("drawCategoryId") int drawCategoryId,
            @Param("instructorId") int instructorId
    );




    @Query(value = "select * from COURSES where courseId = ?", nativeQuery = true)
    Course findCourseByID(@Param("id") int id);

    void editCourse(Course course, int id);
}
