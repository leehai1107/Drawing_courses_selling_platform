package com.main.drawingcourse.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.OrderRepository;

@Component
public class Course_OrderConverter {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CourseConverter courseConverter;
	
	@Autowired
	private NewOrderConveter neworderConverter;
	
	@Autowired
	private OrderConverter orderConverter;
	
	public Course_Order toEntity(Course_OrderModel orderModel) {
		Course_Order courseOrder = new Course_Order();
		courseOrder.setId(orderModel.getId());
		courseOrder.setRating(orderModel.getRating());
		courseOrder.setRegisteredAt(orderModel.getRegistered_at());
		courseOrder.setProgress(orderModel.getProgress());
		courseOrder.setCourse(courseConverter.toEntity(orderModel.getCourse()));
		courseOrder.setOrder(orderConverter.toEntityNew(orderModel.getOrder()));

		return courseOrder;

	}


	public Course_OrderModel toDTO(Course_Order courseOrder) {
		Course_OrderModel orderModel = new Course_OrderModel();
		orderModel.setId(courseOrder.getId());
		orderModel.setRating(courseOrder.getRating());
		orderModel.setRegistered_at(courseOrder.getRegisteredAt());
		orderModel.setProgress(courseOrder.getProgress());
		orderModel.setCourse(courseConverter.toDTO(courseOrder.getCourse()));
		orderModel.setOrder(orderConverter.toResponse(courseOrder.getOrder()));

		return orderModel;
	}

	
}