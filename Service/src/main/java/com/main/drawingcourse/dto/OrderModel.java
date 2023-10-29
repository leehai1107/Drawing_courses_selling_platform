package com.main.drawingcourse.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
	private List<Course_OrderModel> courseOrders;
    private int order_id;
    private String order_code;
    private LocalDate order_date;
    private boolean order_status;
    private double price;
    private int userid;
    private List<Integer> courseIds;

}
