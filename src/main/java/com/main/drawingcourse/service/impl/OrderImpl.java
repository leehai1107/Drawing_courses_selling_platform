package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.service.IOrderService;

public class OrderImpl implements IOrderService {
    @Override
    public void addOrder(OrderModel orderModel) {
        Course order = or.toEntity(CourseModel);
    }
}
