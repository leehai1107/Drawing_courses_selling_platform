package com.main.drawingcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.main.drawingcourse.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
	User findUserByUserName(String userName);
	
	@Modifying
    @Query(value = "update users set password =?1 where user_name=?2 ",nativeQuery = true)
	void saveNewPassword(String password,String user_name);
}
