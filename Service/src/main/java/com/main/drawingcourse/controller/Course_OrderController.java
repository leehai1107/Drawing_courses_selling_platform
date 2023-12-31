package com.main.drawingcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.service.impl.Course_OrderImpl;

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
