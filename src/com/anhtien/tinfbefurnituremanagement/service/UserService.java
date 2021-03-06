package com.anhtien.tinfbefurnituremanagement.service;

import java.sql.SQLException;

import com.anhtien.tinfbefurnituremanagement.dao.UserDAO;
import com.anhtien.tinfbefurnituremanagement.entity.User;

public class UserService {
	
	UserDAO userDAO = new UserDAO();
	
	public boolean insertUser(String username,
			String password,
			String fullname) throws SQLException {
		UserDAO userDAO = new UserDAO();
		boolean isAccountExist = userDAO.isUsernameExists(username);
		if(isAccountExist) {
			return false;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("USER");
		user.setFullname(fullname);
		userDAO.insertUser(user);
		return true;
	}
	
	public User findByUsernameAndPassword(String username, String password) throws SQLException {
		return userDAO.findByUsernameAndPassword(username, password);
	}
	
	public User getUser(Integer userID) throws SQLException{
		return userDAO.findUserID(userID);
	}
	
}
