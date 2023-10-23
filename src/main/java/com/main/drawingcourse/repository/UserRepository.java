package com.main.drawingcourse.repository;

import com.main.drawingcourse.dto.OrderHistory;
import com.main.drawingcourse.dto.OrderHistoryResult;
import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Course_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.main.drawingcourse.entity.User;


import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
@Transactional

public interface UserRepository extends JpaRepository<User, Integer>{
	User findUserByUserName(String userName);
	
	User findUserByEmail(String email);
	
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

	List<User> findAll();

	@Query(value = "SELECT u.fullname AS username, o.order_date AS orderDate, c.title AS courseName\n" +
			"FROM users u\n" +
			"INNER JOIN orders o ON u.user_id = o.user_id\n" +
			"INNER JOIN course_order od ON o.order_id = od.order_id\n" +
			"INNER JOIN courses c ON od.course_id = c.course_id\n" +
			"WHERE u.fullname = :username " +
			"ORDER BY o.order_date",
			nativeQuery = true)
	List<Map<String, OrderHistory>> findOrderHistoryByUsername(@Param("username") String username);


	User findByUserName(String username);



}
