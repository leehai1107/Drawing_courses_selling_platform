package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseReview {

    private int reviewId;
    private String comment;
    private LocalDate reviewDate;
    private int course_id;
    private int order_id;

}
