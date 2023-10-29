package com.main.drawingcourse.payload;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	private int userid;
	private String username;
	private String rolename;
	private String fullname;
	private LocalDate dob;
	private Boolean sex;
	private String description;
	private String phone;
	private String avatar;
	private String email;
}
