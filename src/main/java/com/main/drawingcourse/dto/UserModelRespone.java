package com.main.drawingcourse.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModelRespone {
	private int id;
	private RoleModelResponse roleInfo;
	private String fullname;
}
