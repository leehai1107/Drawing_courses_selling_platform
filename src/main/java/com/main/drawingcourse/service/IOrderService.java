package com.main.drawingcourse.service;

import java.util.List;

import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.entity.Order;

public interface IOrderService {

    OrderModel addOrder(OrderModel orderModel);

	List<Order> getOrderHistoryByUserId(int userId);

}
