package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.OrderModel;

import java.util.List;

public interface IOrderService {

    OrderModel addOrder(OrderModel orderModel, List<Integer> courseIds);
}
