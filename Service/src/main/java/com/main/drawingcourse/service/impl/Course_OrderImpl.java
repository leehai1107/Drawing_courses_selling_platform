package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.Course_OrderConverter;
import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.repository.Course_OrderRepository;
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.ICourse_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
