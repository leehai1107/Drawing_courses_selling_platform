package com.main.drawingcourse.service;

import com.main.drawingcourse.entity.User;

public interface IUserService {

	String addUser(User userInfo);

	User findUserByUserName(String userName);

}
