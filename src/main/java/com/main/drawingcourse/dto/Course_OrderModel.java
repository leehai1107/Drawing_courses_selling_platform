package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course_OrderModel {
    private int id;
    private float progress;
    private int rating;
    private LocalDateTime registered_at;
    private int course_id;
    private int order_id;
}
