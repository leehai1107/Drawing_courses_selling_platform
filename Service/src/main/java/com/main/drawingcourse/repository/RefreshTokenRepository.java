package com.main.drawingcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.drawingcourse.entity.RefreshToken;
import com.main.drawingcourse.entity.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
	RefreshToken findByToken(String token);

	RefreshToken findByUser(User user);

}
