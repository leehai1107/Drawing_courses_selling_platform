package com.main.drawingcourse.controller;

import java.util.List;
import java.util.Map;

import com.main.drawingcourse.dto.OrderHistory;
import com.main.drawingcourse.dto.request.UserHistoryRequestDTO;
import com.main.drawingcourse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.service.IUserService;

@RequestMapping("public/user")
@RestController
public class UserController {

    @Autowired
    IUserService userService;


    @GetMapping(value = "/find-All-Instructor")
    public List<UserModel> findAllInstructor(){
        return userService.findAllInstructor();
    }

    @GetMapping(value = "/find-All-Staff")
    public List<UserModel> findAllStaff(){
        return userService.findAllStaff();
    }

    @GetMapping(value = "/find-All-Customer")
    public List<UserModel> findAllCustomer(){
        return userService.findAllCustomer();
    }

    @PutMapping("edit/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserModel userModel) {
        UserModel userModel1 = userService.GetUserbyid(id);
        if(userModel1!=null){
            userModel1.setAvatar(userModel.getAvatar());
            userModel1.setDescription(userModel.getDescription());
            userModel1.setDob(userModel.getDob());
            userModel1.setFullname(userModel.getFullname());
            userModel1.setPassword(userModel.getPassword());
            userModel1.setSex(userModel.getSex());
            userModel1.setStatus(userModel.isStatus());
            userModel1.setPhone(userModel.getPhone());
            userModel1.setUsername(userModel.getUsername());
            userModel1.setEmail(userModel.getEmail());
            userService.Edit_User( userModel1);
        }

        // You can return a response as needed
    }
    @GetMapping("/Order-History/{username}")
    public List<Map<String, OrderHistory>> getOrderHistoryByUsername(@PathVariable String username) {
        return userService.findOrderHistoryByUsername(username);
    }
}
