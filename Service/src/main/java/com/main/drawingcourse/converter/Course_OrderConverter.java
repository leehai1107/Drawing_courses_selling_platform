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

	public Collection<Course_Order> convertToCourseOrderCollection(List<Course_OrderModel> courseOrderModels) {
		Collection<Course_Order> courseOrders = new ArrayList<>();
		for (Course_OrderModel courseOrderModel : courseOrderModels) {
			Course_Order courseOrder = toEntity(courseOrderModel);
			courseOrders.add(courseOrder);
		}
		return courseOrders;
	}

	public List<Course_OrderModel> convertToCourseOrderModelList(Collection<Course_Order> courseOrders) {
		List<Course_OrderModel> courseOrderModels = new ArrayList<>();
		for (Course_Order courseOrder : courseOrders) {
			Course_OrderModel courseOrderModel = toDTO(courseOrder);
			courseOrderModels.add(courseOrderModel);
		}
		return courseOrderModels;
	}
}