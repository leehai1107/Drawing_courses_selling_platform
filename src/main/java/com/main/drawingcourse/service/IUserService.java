package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.entity.User;

import java.util.List;

public interface IUserService {

	String addUser(User userInfo);

	User findUserByUserName(String userName);

	String sendEmail(User user);

	List<UserModel> findAllInstructor();
	List<UserModel> findAllStaff();
	List<UserModel> findAllCustomer();

	void Edit_User(UserModel userModel);
	UserModel GetUserbyid(int id);
}
