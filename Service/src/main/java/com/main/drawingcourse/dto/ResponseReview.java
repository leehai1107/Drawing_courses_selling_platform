package com.main.drawingcourse.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
