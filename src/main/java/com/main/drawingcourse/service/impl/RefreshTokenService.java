package com.main.drawingcourse.service.impl;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.entity.RefreshToken;
import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.repository.RefreshTokenRepository;
import com.main.drawingcourse.repository.UserRepository;

@Service
public class RefreshTokenService {
	public static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 3;// 3m

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	@Autowired
	private UserRepository userInfoRepository;
	

	public RefreshToken createRefreshToken(String username) {
		User user = userInfoRepository.findUserByUserName(username);
		RefreshToken refreshToken = RefreshToken.builder().user(user)
				.token(UUID.randomUUID().toString()).expiryDate(Instant.now().plusMillis(JWT_TOKEN_VALIDITY)).build();

		if(refreshTokenRepository.findByUser(user)!=null) {
			refreshTokenRepository.delete(refreshTokenRepository.findByUser(user));
		}

		return refreshTokenRepository.save(refreshToken);
	}

	public RefreshToken findByToken(String token) {
		return refreshTokenRepository.findByToken(token);
	}

	public RefreshToken verifyExpiration(RefreshToken token) {
		if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
			refreshTokenRepository.delete(token);
			throw new RuntimeException(
					token.getToken() + " Refresh token was expired. Please make a new signin request");
		}
		return token;
	}

	public void removeFromInstance(RefreshToken token) {
		refreshTokenRepository.delete(token);
		
	}

}
