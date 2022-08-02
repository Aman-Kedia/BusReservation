package com.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bms.dao.UserDao;
import com.bms.dto.UpdateUser;
import com.bms.entity.User;
import com.bms.exception.PrintExceptionMessage;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	EmailService emailService;

	public String signUp(User user) {
		try {
			User user2 = userDao.addOrUpdateUser(user);
			String email = user2.getEmail();
			String text = "Your UserID = " + user2.getUserId() + "\nYour password = " + user2.getPassword();
			String subject = "Registration Confirmation";
			emailService.sendEmailForSignUp(email, text, subject);
			System.out.println("Email Sent");
			return "Sign up successful.Your userId :" + user2.getUserId();
		} catch (Exception e) {
			return "Sign up failed";
		}
	}

	public UpdateUser updateUser(User user) {
		UpdateUser upd = new UpdateUser();
		try {
			if (user.getUserId() == 0) {
				throw new PrintExceptionMessage("Please mention userId");
			} else if (userDao.findUserByUserId(user.getUserId()) == null) {
				throw new PrintExceptionMessage("User not found");
			} else {
				User user2 = userDao.addOrUpdateUser(user);
				upd.setMessage("Profile Updated Successfully");
				upd.setUser(user2);
				return upd;
			}
		} catch (Exception e) {
			upd.setMessage(e.getMessage());
			return upd;
		}
	}

	public User findUser(String email) {
		return userDao.findUserByEmailId(email);
	}

	public List<User> viewAllUsers() {
		return userDao.viewAllUsers();
	}

	public boolean userLogin(String email, String password) {
		try {
			return userDao.login(email, password);
		} catch (Exception e) {
			return false;
		}
	}

	public String getUserName(int userId) {
		return (userDao.findUserByUserId(userId).getFirstName() + " " + userDao.findUserByUserId(userId).getLastName());
	}

}
