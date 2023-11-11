package com.main.drawingcourse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.response.OrderResponse;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.repository.UserRepository;

@Component
public class NewOrderConveter {
	@Autowired
	UserRepository userRepository;
	
	public Order toEntityNew(OrderResponse orderModel) {
		Order entity = new Order();
		entity.setOrderId(orderModel.getOrder_id());
		entity.setOrderCode(orderModel.getOrder_code());
		entity.setOrderStatus(orderModel.isOrder_status());
		entity.setPrice(orderModel.getPrice());
		entity.setUser(userRepository.getReferenceById(orderModel.getUserid()));
		
		return entity;
	}
}
