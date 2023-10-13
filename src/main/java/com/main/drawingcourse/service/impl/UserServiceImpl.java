package com.main.drawingcourse.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.main.drawingcourse.converter.UserConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.entity.Course;
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
			String text = "<table width=\"70%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "                                \r\n" + "                                <tbody><tr>\r\n"
					+ "                                    <td class=\"m_-8399017969784665406mpy-35 m_-8399017969784665406mpx-15\" bgcolor=\"#dbdbdb\" style=\"padding:80px\">\r\n"
					+ "                                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "\r\n" + "                                            \r\n"
					+ "                                            <tbody>\r\n"
					+ "                                            <tr>\r\n"
					+ "                                                <td>\r\n" + "\r\n"
					+ "			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "				<tbody><tr>\r\n" + "\r\n" + "			</tbody></table>\r\n" + "   <br>\r\n"
					+ "   <br>\r\n"
					+ "						<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "				<tbody><tr>\r\n"
					+ "					<td style=\"font-size:18px;line-height:25px;font-family:Arial,sans-serif,'Motiva Sans';text-align:left;padding-bottom:30px\">Đây là mật khẩu mới cho tài khoản "
					+ user.getUserName() + " của bạn:</td>\r\n" + "				</tr>\r\n"
					+ "			</tbody></table>\r\n"
					+ "						<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "				<tbody><tr>\r\n"
					+ "					<td class=\"m_-8399017969784665406mpb-50\" style=\"padding-bottom:70px\">\r\n"
					+ "						<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#dbdbdb\">\r\n"
					+ "							<tbody><tr>\r\n"
					+ "								<td style=\"padding-top:30px;padding-bottom:30px;padding-left:56px;padding-right:56px\">\r\n"
					+ "									<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "																				<tbody><tr>\r\n"
					+ "											<td style=\"font-size:48px;line-height:52px;font-family:Arial,sans-serif,'Motiva Sans';font-weight:bold;text-align:center\">\r\n"
					+ "												" + newPassword
					+ "									</td>\r\n" + "										</tr>\r\n"
					+ "									</tbody></table>\r\n"
					+ "								</td>\r\n" + "							</tr>\r\n"
					+ "						</tbody></table>\r\n" + "					</td>\r\n"
					+ "				</tr>\r\n" + "			</tbody>\r\n"
					+ "			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "				<tbody><tr>\r\n"
					+ "					<td style=\"font-size:18px;line-height:25px;font-family:Arial,sans-serif,'Motiva Sans';text-align:left;padding-bottom:30px\">Email này được tạo thông qua yêu cầu quên mật khẩu của bạn.<br><br><span style=\"font-weight:bold\">Vui lòng nhập chính xác tài khoản và mật khẩu mới để đăng nhập.</span>\r\n"
					+ "</td>\r\n" + "				</tr>\r\n"
					+ "			</tbody></table><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "                                                    <tbody><tr>\r\n"
					+ "                                                        <td style=\"padding-top:30px\">\r\n"
					+ "                                                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "                                                                <tbody><tr>\r\n"
					+ "                                                                    <td width=\"3\" bgcolor=\"#dbdbdb\" style=\"font-size:0pt;line-height:0pt;text-align:left\"></td>\r\n"
					+ "                                                                    <td width=\"37\" style=\"font-size:0pt;line-height:0pt;text-align:left\"></td>\r\n"
					+ "                                                                    <td>\r\n"
					+ "                                                                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
					+ "                                                                            <tbody><tr> <td style=\"font-size:16px;line-height:22px;font-family:Arial,sans-serif,'Motiva Sans';text-align:left;padding-top:20px;padding-bottom:20px\">\r\n"
					+ "                                                                                        Trân trọng,<br>Mỹ Thuật Bụi</td>\r\n"
					+ "                                                                                                                                                            </tr>\r\n"
					+ "                                                                        </tbody></table>\r\n"
					+ "                                                                    </td>\r\n"
					+ "                                                                </tr>\r\n"
					+ "                                                            </tbody></table>\r\n"
					+ "                                                        </td>\r\n"
					+ "                                                    </tr>\r\n"
					+ "                                                </tbody></table>\r\n"
					+ "			</table>\r\n" + "						\r\n"
					+ "                                                \r\n"
					+ "                                                \r\n"
					+ "                                                </td>\r\n"
					+ "                                            </tr>\r\n" + "\r\n"
					+ "                                        </tbody></table>\r\n"
					+ "                                    </td>\r\n" + "                                </tr>\r\n"
					+ "                                \r\n" + "\r\n" + "                                \r\n"
					+ "                                \r\n" + "                            \r\n"
					+ "                            </tbody></table>";

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
