package com.main.drawingcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.main.drawingcourse.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findUserByUserName(String userName);
	
	@Modifying
    @Query(value = "update users set password =?1 where user_name=?2 ",nativeQuery = true)
	void saveNewPassword(String newpassword,String email);
}
