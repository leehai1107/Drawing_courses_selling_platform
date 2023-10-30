package com.main.drawingcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.drawingcourse.entity.Course;

@Repository

public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Query(value = "select * from courses where instructor_id = :id", nativeQuery = true)
	List<Course> findAllCoursesByInstructorId(@Param("id") int id);

	@Query(value = "SELECT * FROM COURSES c WHERE c.title = :title AND c.instructor_id = :id", nativeQuery = true)
	Course findCoursesByTitleAndInstructorID(@Param("title") String title, @Param("id") int id);

	@Query(value = "SELECT * FROM COURSES c WHERE c.title = :title", nativeQuery = true)
	List<Course> findCoursesByTitle(@Param("title") String title);

	@Query(value = "SELECT * FROM COURSES c WHERE c.price BETWEEN :start_price AND :end_price", nativeQuery = true)
	List<Course> findCoursesByPriceRange(@Param("start_price") double start_price,
			@Param("end_price") double end_price);

	@Query(value = "SELECT c.* FROM Courses c INNER JOIN course_order co ON c.course_id = co.course_id INNER JOIN orders o ON co.order_id = o.order_id WHERE o.user_id = :id", nativeQuery = true)
	List<Course> findAllCourseHasOrderByUserId(@Param("id") int id);

	@Query(value = "SELECT c.* FROM Courses c INNER JOIN course_order co ON c.course_id = co.course_id INNER JOIN orders o ON co.order_id = o.order_id WHERE o.user_id = :id and o.order_status  = 1", nativeQuery = true)
	List<Course> findAllCourseHasOrderTrueByUserId(@Param("id") int id);

	@Query(value = "SELECT c.course_id, c.title, c.description, c.price, c.rating, c.course_image, c.draw_category_id, c.level_id, c.instructor_id, c.status FROM Courses c JOIN Users u ON c.instructor_id = u.user_id WHERE u.user_name = :name", nativeQuery = true)
	List<Course> findAllCourseOfInstructorByUserName(@Param("name") String name);

	@Query(value = "SELECT * FROM COURSES WHERE course_id = :id", nativeQuery = true)
	Course findCourseByID(@Param("id") int id);

	@Query(value = "SELECT TOP 4 c.course_id, c.title, c.description, c.price, c.rating, c.course_image, c.draw_category_id, c.level_id, c.instructor_id, c.status FROM Courses c JOIN course_order co ON c.course_id = co.course_id GROUP BY c.course_id, c.title, c.description, c.price, c.rating, c.course_image, c.draw_category_id, c.level_id, c.instructor_id, c.status ORDER BY COUNT(co.order_id) DESC", nativeQuery = true)
	List<Course> findTop4BestSellerCourse();

	@Query(value = "SELECT * FROM COURSES c WHERE c.status = 1", nativeQuery = true)
	List<Course> viewcoursewithstatustrue(@Param("status") boolean status);

	@Query(value = "UPDATE Courses SET status = 'true' WHERE course_id = :id AND status = 'false' ", nativeQuery = true)
	Course UpdateStatusOfCourse(@Param("id") int id);

	@Query(value = "select * from COURSES c  where c.level_id = :levelid and c.draw_category_id = :cateid  and c.status = 1", nativeQuery = true)
	List<Course> findbycateidandlevelid(@Param("cateid") int cateid, @Param("levelid") int levelid);

}
