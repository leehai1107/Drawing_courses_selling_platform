package com.main.drawingcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.converter.OrderConverter;
import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.service.IOrderService;
import com.main.drawingcourse.service.IUserService;

@RequestMapping("public/user")
@RestController
public class UserController {

	@Autowired
	IUserService userService;

	@Autowired
	IOrderService orderService;

	@Autowired
	OrderConverter orderConverter;

	@GetMapping(value = "/find-All-Instructor")
	public List<UserModel> findAllInstructor() {
		return userService.findAllInstructor();
	}

	@GetMapping(value = "/find-All-Staff")
	public List<UserModel> findAllStaff() {
		return userService.findAllStaff();
	}

	@GetMapping(value = "/find-All-Customer")
	public List<UserModel> findAllCustomer() {
		return userService.findAllCustomer();
	}

	@PutMapping("edit")
	public ResponseEntity<?> updateUser(@RequestBody UserModel userModel) {
		UserModel userModel1 = userService.GetUserbyid(userModel.getUserid());

		if (userModel1 != null) {
			userModel1.setAvatar(userModel.getAvatar());
			userModel1.setDescription(userModel.getDescription());
			userModel1.setDob(userModel.getDob());
			userModel1.setFullname(userModel.getFullname());
			userModel1.setSex(userModel.getSex());
			userModel1.setPhone(userModel.getPhone());
			userModel1.setEmail(userModel.getEmail());
			userService.Edit_User(userModel1);
			return ResponseEntity.ok("User updated successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/orders/{userid}")
	public List<OrderModel> getOrderHistoryByUsername(@PathVariable int userid) {
		List<Order> list = orderService.getOrderHistoryByUserId(userid);
		return orderConverter.convertToOrderModelList(list);
	}

	@GetMapping("/infor/{id}")
	public UserModel getUserById(@PathVariable int id, UserModel userModel) {
		var user = userService.GetUserbyid(id);
		if (user != null) {
			userModel = user;
		}
		return userModel;
	}
}
