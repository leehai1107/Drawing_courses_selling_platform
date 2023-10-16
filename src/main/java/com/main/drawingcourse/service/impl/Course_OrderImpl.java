package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.Course_OrderConverter;
import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.repository.Course_OrderRepository;
import com.main.drawingcourse.service.ICourse_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Course_OrderImpl implements ICourse_OrderService {

    @Autowired
    Course_OrderConverter courseOrderConverter;
    @Autowired
    Course_OrderRepository courseOrderRepository;

}
