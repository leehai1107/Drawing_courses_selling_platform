package com.main.drawingcourse.dto;

import java.time.LocalDate;

public interface OrderHistoryResult {
    String getUsername();
    LocalDate getOrderDate();
    String getCourseName();

}
