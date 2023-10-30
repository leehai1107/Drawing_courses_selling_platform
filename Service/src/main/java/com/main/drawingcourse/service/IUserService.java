package com.main.drawingcourse.service;

import java.util.List;

import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.entity.User;

public interface IUserService {

	String addUser(User userInfo);

	User findUserByUserName(String userName);

	String sendEmail(User user);

	List<UserModel> findAllInstructor();

	List<UserModel> findAllStaff();

	List<UserModel> findAllCustomer();

	void Edit_User(UserModel userModel);

	UserModel GetUserbyid(int id);

	User findUserByEmail(String email);

	String changePassword(User user, String passwordEnter, String newPassword);

	User getReferenceById(Integer id);

}
