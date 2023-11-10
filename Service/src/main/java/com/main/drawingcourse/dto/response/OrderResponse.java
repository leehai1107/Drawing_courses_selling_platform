package com.main.drawingcourse.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
	private int order_id;
	private String order_code;
	private boolean order_status;
	private double price;
	private int userid;
}
