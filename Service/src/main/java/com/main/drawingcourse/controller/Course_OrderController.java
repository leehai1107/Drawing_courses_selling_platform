package com.main.drawingcourse.controller;

import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.service.impl.Course_OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("public/Course_Order")
public class Course_OrderController {
    @Autowired
    Course_OrderImpl course_order;


    @GetMapping("/total-sales-amount")
    public Double getTotalSalesAmount() {
        Double totalSalesAmount = course_order.getTotalSalesAmount();
        return totalSalesAmount;
    }

}
