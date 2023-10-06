package com.main.drawingcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.drawingcourse.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findUserByUserName(String userName);
}
