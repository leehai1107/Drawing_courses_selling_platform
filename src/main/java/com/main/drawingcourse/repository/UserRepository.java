package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.main.drawingcourse.entity.User;


import java.util.List;
import java.util.Optional;


@Repository
@Transactional

public interface UserRepository extends JpaRepository<User, Integer>{
	User findUserByUserName(String userName);
	
	@Modifying
    @Query(value = "update users set password =?1 where user_name=?2 ",nativeQuery = true)
		void saveNewPassword(String newpassword,String email);

	@Query(
			value = "SELECT * FROM USERS c WHERE c.role_id = 4",
			nativeQuery = true)
	List<User> findAllInstructor();

	@Query(
			value = "SELECT * FROM USERS c WHERE c.role_id = 2",
			nativeQuery = true)
	List<User> findAllStaff();

	@Query(
			value = "SELECT * FROM USERS c WHERE c.role_id = 3",
			nativeQuery = true)
	List<User> findAllCustomer();
	@Query(
			value = "SELECT * FROM USERS c WHERE c.user_Id = :id  AND c.role_id = 4 ",
			nativeQuery = true
	)
	Optional<User> findByIdAndRole( int id);

}
