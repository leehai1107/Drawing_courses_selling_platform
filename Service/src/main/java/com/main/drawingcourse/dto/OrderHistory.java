package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {
    private String username;
    private LocalDate orderDate;
    private String courseName;


}
