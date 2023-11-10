package com.main.drawingcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.main.drawingcourse.entity.Course_Order;

@Repository
@Transactional
public interface Course_OrderRepository extends JpaRepository<Course_Order, Integer> {
	@Query("SELECT SUM(c.price) FROM Course_Order co " + "JOIN co.course c " + "JOIN co.order o")
	Double getTotalSalesAmount();

	@Query(value = "select id from course_order where course_id = :cid AND order_id = :oid", nativeQuery = true)
	int findCourseAndOrderID(@Param("cid") int cid, @Param("oid") int oid);
	
	  @Modifying
	    @Query("DELETE FROM Course_Order co WHERE co.order.orderId = :orderId")
	    void deleteByOrderId(int orderId);
	  
	  @Query(value = "SELECT co.* FROM course_order co INNER JOIN Courses c ON c.course_id = co.course_id INNER JOIN orders o ON co.order_id = o.order_id WHERE o.user_id = :id",
			  nativeQuery = true)
	  List<Course_Order> findCoursesWithOrdersForUser(@Param("id") int id);

}
