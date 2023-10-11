package com.main.drawingcourse.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	EmailSenderService emailSender;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findUserByUserName(userName);
	}

	@Override
	public String addUser(User userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userRepository.save(userInfo);
		return "user added to system ";
	}

	@Override
	public String sendEmail(User user) {

		try {
			String subject = "MẬT KHẨU ĐĂNG NHẬP MỚI";
			String newPassword = generateRandomPassword(8);
			String text = "Mật khẩu đăng nhập của tài khoản " + user.getUserName() + " là \n\n"
					+ newPassword + "\n\n VUI LÒNG KHÔNG CHIA SẺ MẬT KHẨU NÀY CHO AI KHÁC! Xin cảm ơn.";

			emailSender.sendEmail(user.getUserName(), text, subject);
			userRepository.saveNewPassword(passwordEncoder.encode(newPassword), user.getUserName());

			return "Success!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error!";
		}
	}

	private String generateRandomPassword(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			sb.append(randomChar);
		}

		return sb.toString();
	}
}
