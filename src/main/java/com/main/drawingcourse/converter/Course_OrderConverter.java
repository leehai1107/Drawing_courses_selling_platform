package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Course_OrderConverter {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private OrderRepository orderRepository;



    public Course_Order toEntity(Course_OrderModel orderModel) {
        Course_Order courseOrder = new Course_Order();
        courseOrder.setId(orderModel.getId());
        courseOrder.setRating(orderModel.getRating());
        courseOrder.setRegisteredAt(orderModel.getRegistered_at());
        courseOrder.setProgress(orderModel.getProgress());
        courseOrder.setCourse(courseRepository.getReferenceById(orderModel.getCourse_id()));
        courseOrder.setOrder(orderRepository.getReferenceById(orderModel.getOrder_id()));


        return courseOrder;

    }

    public Course_OrderModel toDTO(Course_Order courseOrder) {
        Course_OrderModel orderModel = new Course_OrderModel();
        orderModel.setId(courseOrder.getId());
        orderModel.setRating(courseOrder.getRating());
        orderModel.setRegistered_at(courseOrder.getRegisteredAt());
        orderModel.setProgress(courseOrder.getProgress());
        orderModel.setCourse_id(courseOrder.getCourse().getCourseId());
        orderModel.setOrder_id(courseOrder.getOrder().getOrderId());

        return orderModel;
    }
}