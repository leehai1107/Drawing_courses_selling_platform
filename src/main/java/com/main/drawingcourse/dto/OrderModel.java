package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    private int user_id;
    public void setCourseOrders(List<Course_OrderModel> courseOrders) {
        this.courseOrders = courseOrders;
    }
}
