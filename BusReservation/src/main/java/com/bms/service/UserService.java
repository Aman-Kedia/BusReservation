package com.bms.service;

import java.util.List;

import com.bms.dto.UpdateUser;
import com.bms.entity.User;

public interface UserService {
	String signUp(User user);
	
	UpdateUser updateUser(User user);
	
	User findUser(String email);
	
	List<User> viewAllUsers();
	
	boolean userLogin(String email,String password);
	
	String getUserName(int userId);
}
