package com.main.drawingcourse.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


import com.main.drawingcourse.converter.Course_OrderConverter;
import com.main.drawingcourse.converter.UserConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.repository.RoleRepository;
import jakarta.persistence.EntityManager;
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

	@Autowired
	UserConverter userConverter;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	Course_OrderConverter courseOrderConverter;

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findUserByUserName(userName);
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public List<UserModel> findByUsernameAndOrderDate(String username) {
		List<User> UserEntity = userRepository.findOrderHistoryByUsername(username);
		List<UserModel> UserModels = UserEntity.stream()
				.map(userConverter::toDto)
				.collect(Collectors.toList());
		return UserModels;



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
			String text = "<table width=\"70%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#dbdbdb\" style=\"font-family:Arial,sans-serif,'Motiva Sans';text-align:left;padding-bottom:30px;padding:80px\">\r\n"
					+ "	<td>\r\n"
					+ "		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "			<tbody>\r\n"
					+ "				<tr>\r\n"
					+ "					<td>\r\n"
					+ "						<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "							<tbody>\r\n"
					+ "								<tr>\r\n"
					+ "									<td style=\"font-size:18px;line-height:25px;\">Đây là mật khẩu mới cho tài khoản "+ user.getUserName() +" của bạn:</td>\r\n"
					+ "								</tr>\r\n"
					+ "							</tbody>\r\n"
					+ "						</table>\r\n"
					+ "						<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "							<tbody>\r\n"
					+ "								<tr>\r\n"
					+ "									<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#dbdbdb\">\r\n"
					+ "										<tbody>\r\n"
					+ "											<tr>\r\n"
					+ "												<td style=\"padding-top:30px;padding-bottom:30px;padding-left:56px;padding-right:56px\">\r\n"
					+ "													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "														<tbody>\r\n"
					+ "															<tr>\r\n"
					+ "																<td style=\"font-size:32px;line-height:52px;font-weight:bold;text-align:center\">\r\n"
					+ "												"+ newPassword +"</td>\r\n"
					+ "															</tr>\r\n"
					+ "														</tbody>\r\n"
					+ "													</table>\r\n"
					+ "												</td>\r\n"
					+ "											</tr>\r\n"
					+ "										</tbody>\r\n"
					+ "									</table>\r\n"
					+ "								</tr>\r\n"
					+ "							</tbody>\r\n"
					+ "							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "								<tbody>\r\n"
					+ "									<tr>\r\n"
					+ "										<td style=\"font-size:18px;line-height:25px;\">Email này được tạo thông qua yêu cầu quên mật khẩu của bạn.<br>\r\n"
					+ "												<br>\r\n"
					+ "													<span style=\"font-weight:bold\">Vui lòng nhập chính xác tài khoản và mật khẩu mới để đăng nhập.</span>\r\n"
					+ "												</td>\r\n"
					+ "											</tr>\r\n"
					+ "										</tbody>\r\n"
					+ "									</table>\r\n"
					+ "									<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "										<tbody>\r\n"
					+ "											<tr>\r\n"
					+ "												<td style=\"font-size:16px;line-height:22px;padding-top:20px;padding-bottom:20px\">\r\n"
					+ "                                                                                        Trân trọng,<br>Mỹ Thuật Bụi</td>\r\n"
					+ "												</tr>\r\n"
					+ "											</tbody>\r\n"
					+ "										</table>\r\n"
					+ "									</td>\r\n"
					+ "								</tr>\r\n"
					+ "							</tbody>\r\n"
					+ "						</table>\r\n"
					+ "					</td>\r\n"
					+ "				</table>\r\n"
					+ "			</table>";

			emailSender.sendEmail(user.getUserName(), text, subject);
			userRepository.saveNewPassword(passwordEncoder.encode(newPassword), user.getUserName());

			return "Success!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error!";
		}
	}

	@Override
	public List<UserModel> findAllInstructor() {
		List<User> userEntity = userRepository.findAllInstructor();
		List<UserModel> userModels = userEntity.stream().map(userConverter::toDto).collect(Collectors.toList());

		return userModels;
	}

	@Override
	public List<UserModel> findAllStaff() {
		List<User> userEntity = userRepository.findAllStaff();
		List<UserModel> userModels = userEntity.stream().map(userConverter::toDto).collect(Collectors.toList());

		return userModels;
	}

	@Override
	public List<UserModel> findAllCustomer() {
		List<User> userEntity = userRepository.findAllCustomer();
		List<UserModel> userModels = userEntity.stream().map(userConverter::toDto).collect(Collectors.toList());

		return userModels;
	}

	@Override
	public void Edit_User(UserModel userModel) {
		User user = userConverter.toEntity(userModel);

			user.setAvatar(user.getAvatar());
			user.setDescription(user.getDescription());
			user.setDob(user.getDob());
			user.setEmail(user.getEmail());
			user.setFullname(user.getFullname());
			user.setPassword(user.getPassword());
			user.setPhone(user.getPhone());
			user.setSex(user.getSex());
			user.setStatus(user.isStatus());
			user.setUserName(user.getUserName());

			var u = roleRepository.findById(user.getUserId()).orElse(null);
			if(u !=null){
				user.setRole(u);
			}
			user = userRepository.save(user);

			// You can return the updated CourseModel if needed
			UserModel updatedUserModel = userConverter.toDto(user);


	}

	@Override
	public UserModel GetUserbyid(int id) {
		var user = userRepository.findById(id).orElse(null);
		if(user!= null){
			return userConverter.toDto(user);
		}
		return new UserModel();


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


	public String changePassword(User user,String passwordEnter, String newPassword) {
		if(passwordEncoder.matches(passwordEnter, user.getPassword())) {
			userRepository.saveNewPassword(passwordEncoder.encode(newPassword), user.getUserName());
			return "Password has changed!";
		}
		return "Password has enter does not match with old password!";
	}


}
