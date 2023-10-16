package com.main.drawingcourse.controller;

import com.main.drawingcourse.converter.OrderConverter;
import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private OrderConverter orderConverter;
    @GetMapping("/view")
    public void view(){
        System.out.printf("hello");
    }
    @PostMapping("/add")
    public OrderModel addOrder(@RequestBody OrderModel orderModel, @RequestParam List<Integer> courseIds) {

            OrderModel createdOrder = orderService.addOrder(orderModel, courseIds);
            return createdOrder;

    }
}
