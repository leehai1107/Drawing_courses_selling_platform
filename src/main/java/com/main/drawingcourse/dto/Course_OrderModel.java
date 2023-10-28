package com.main.drawingcourse.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course_OrderModel {
    private int id;
    private float progress;
    private int rating;
    private LocalDate registered_at;
    private int course_id;
    private int order_id;
}
