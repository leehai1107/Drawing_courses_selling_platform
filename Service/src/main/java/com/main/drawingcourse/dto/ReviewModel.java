package com.main.drawingcourse.dto;

import com.main.drawingcourse.entity.Course_Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewModel {
    private int reviewId;
    private String comment;
    private LocalDate reviewDate;
    private int id;
    private Course_OrderModel course_Order;
    private ResponseCourse responseCourse;
    private OrderModel orderModel;
    private int course_id;
    private int order_id;
}
