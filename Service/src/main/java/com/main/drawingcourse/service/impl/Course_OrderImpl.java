package com.main.drawingcourse.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.drawingcourse.converter.Course_OrderConverter;
import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.repository.Course_OrderRepository;
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.ICourse_OrderService;

@Service
@Lazy
public class Course_OrderImpl implements ICourse_OrderService {

	@Autowired
	Course_OrderConverter courseOrderConverter;
	@Autowired
	Course_OrderRepository courseOrderRepository;
	@Autowired
	UserRepository userRepository;

	@Transactional(readOnly = true)
	public Double getTotalSalesAmount() {
		return courseOrderRepository.getTotalSalesAmount();
	}
	
	@Override
	public List<Course_OrderModel> findCourseHasOrder(int userid){
		List<Course_Order> courseEntities = courseOrderRepository.findCoursesWithOrdersForUser(userid);
		List<Course_OrderModel> courseModels = courseEntities.stream().map(courseOrderConverter::toDTO)
				.collect(Collectors.toList());

		return courseModels;
	}

}
