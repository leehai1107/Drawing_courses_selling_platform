package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
