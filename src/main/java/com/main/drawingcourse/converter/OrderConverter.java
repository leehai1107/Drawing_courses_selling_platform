package com.main.drawingcourse.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.repository.UserRepository;

@Component
public class OrderConverter {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Course_OrderConverter course_OrderConverter;

    public Order toEntity(OrderModel orderModel) {
        Order entity = new Order();
        entity.setOrderId(orderModel.getOrder_id());
        entity.setOrderCode(orderModel.getOrder_code());
        entity.setOrderDate(orderModel.getOrder_date());
        entity.setOrderStatus(orderModel.isOrder_status());
        entity.setPrice(orderModel.getPrice());
        entity.setUser(userRepository.getReferenceById(orderModel.getUserid()));
        entity.setCourse_Orders(course_OrderConverter.convertToCourseOrderCollection(orderModel.getCourseOrders()));
        return entity;
    }

    public OrderModel toDTO(Order orderEntity) {
        OrderModel dto = new OrderModel();
        dto.setOrder_id(orderEntity.getOrderId());
        dto.setOrder_code(orderEntity.getOrderCode());
        dto.setOrder_date(orderEntity.getOrderDate());
        dto.setOrder_status(orderEntity.getOrderStatus());
        dto.setPrice(orderEntity.getPrice());
        dto.setUserid(orderEntity.getUser().getUserId());
        dto.setCourseOrders(course_OrderConverter.convertToCourseOrderModelList(orderEntity.getCourse_Orders()));
        return dto;
    }
    

    public List<OrderModel> convertToOrderModelList(List<Order> orderList) {
        List<OrderModel> orderModelList = new ArrayList<>();
        for (Order order : orderList) {
            OrderModel orderModel = toDTO(order);
            orderModelList.add(orderModel);
        }
        return orderModelList;
    }
}