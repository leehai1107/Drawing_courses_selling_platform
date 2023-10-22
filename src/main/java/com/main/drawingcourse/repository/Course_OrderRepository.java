package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Course_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface Course_OrderRepository extends JpaRepository<Course_Order, Integer> {
    @Query("SELECT SUM(c.price) FROM Course_Order co " +
            "JOIN co.course c " +
            "JOIN co.order o")
    Double getTotalSalesAmount();


}
