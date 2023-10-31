package com.main.drawingcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.drawingcourse.entity.Review;

public interface ReviewRepositoty extends JpaRepository<Review, Integer> {
	@Query(value = "SELECT r.* FROM Courses c INNER JOIN course_order co ON c.course_id = co.course_id INNER JOIN Reviews r ON co.id = r.id WHERE co.order_id IN (SELECT order_id FROM orders WHERE user_id = :id)", nativeQuery = true)
	List<Review> findAllFeedBacksByUserId(@Param("id") int id);

	@Query(value = "SELECT\n" + "    r.*\n" + "FROM\n" + "    Reviews r\n" + "INNER JOIN\n"
			+ "    course_order co ON r.id = co.id\n" + "INNER JOIN\n" + "    orders o ON co.order_id = o.order_id\n"
			+ "INNER JOIN\n" + "    Users u ON o.user_id = u.user_id\n" + "WHERE\n"
			+ "    co.course_id = :id", nativeQuery = true)
	List<Review> findAllFeedBacksByCourse(@Param("id") int id);

}
