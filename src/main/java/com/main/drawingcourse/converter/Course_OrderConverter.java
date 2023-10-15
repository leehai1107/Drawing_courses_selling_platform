package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Course_OrderConverter {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    OrderRepository orderRepository;

    public Course_Order toEntity(Course_OrderModel course_orderModel) {
        Course_Order entity = new Course_Order();
        entity.setId(course_orderModel.getId());
        entity.setProgress(course_orderModel.getProgress());
        entity.setRating(course_orderModel.getRating());
        entity.setRegisteredAt(course_orderModel.getRegistered_at());
        entity.setCourse(courseRepository.getReferenceById(course_orderModel.getCourse_id()));
        entity.setOrder(orderRepository.getReferenceById(course_orderModel.getOrder_id()));
        return entity;
    }

    public Course_OrderModel toDTO(Course_Order course_orderEntity) {
        Course_OrderModel dto = new Course_OrderModel();
        dto.setId(course_orderEntity.getId());
        dto.setProgress(course_orderEntity.getProgress());
        dto.setRating(course_orderEntity.getRating());
        dto.setRegistered_at(course_orderEntity.getRegisteredAt());
        dto.setCourse_id(course_orderEntity.getCourse().getCourseId());
        dto.setOrder_id(course_orderEntity.getOrder().getOrderId());
        return dto;
    }
}