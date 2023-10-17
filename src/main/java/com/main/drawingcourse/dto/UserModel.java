package com.main.drawingcourse.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
	private int id;
	private String userName;
	private String password;
	private Boolean status;
	private int roleId;
	private RoleModelResponse roleModelResponse;
	private String avatar;
	private LocalDate dob;
	private boolean sex;
	private String description;
	private String fullname;
}
