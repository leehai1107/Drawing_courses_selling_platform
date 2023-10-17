package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    @Autowired
    UserRepository userRepository;

    public Order toEntity(OrderModel orderModel) {
        Order entity = new Order();
        entity.setOrderId(orderModel.getOrder_id());
        entity.setOrderCode(orderModel.getOrder_code());
        entity.setOrderDate(orderModel.getOrder_date());
        entity.setOrderStatus(orderModel.isOrder_status());
        entity.setPrice(orderModel.getPrice());
        entity.setUser(userRepository.getReferenceById(orderModel.getUser_id()));
        return entity;
    }

    public OrderModel toDTO(Order orderEntity) {
        OrderModel dto = new OrderModel();
        dto.setOrder_id(orderEntity.getOrderId());
        dto.setOrder_code(orderEntity.getOrderCode());
        dto.setOrder_date(orderEntity.getOrderDate());
        dto.setOrder_status(orderEntity.getOrderStatus());
        dto.setPrice(orderEntity.getPrice());
        dto.setUser_id(orderEntity.getUser().getUserId());
        return dto;
    }
}