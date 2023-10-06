package com.main.drawingcourse.jwt;

public class JwtResponse {
	private String token;
	private String type ="Bearer";
	private Integer id;
	private String userName;
	private String role;
	
	public JwtResponse(String token, Integer id, String userName, String role) {
		super();
		this.token = token;
		this.id = id;
		this.userName = userName;
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
	
	
}
