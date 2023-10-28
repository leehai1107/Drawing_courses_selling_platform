package com.main.drawingcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.entity.User;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findByOrderCode(String orderCode);
    
    List<Order> findByUser(User user);
}
