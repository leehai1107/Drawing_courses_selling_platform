package com.main.drawingcourse.payload;

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

}
