package com.main.drawingcourse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.drawingcourse.converter.Course_OrderConverter;
import com.main.drawingcourse.repository.Course_OrderRepository;
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.ICourse_OrderService;

@Service
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

}
