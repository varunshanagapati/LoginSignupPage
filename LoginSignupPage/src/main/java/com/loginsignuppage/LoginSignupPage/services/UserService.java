package com.loginsignuppage.LoginSignupPage.services;


import com.loginsignuppage.LoginSignupPage.entity.LoginEntity;
import com.loginsignuppage.LoginSignupPage.entity.User;

public interface UserService {
	public String addUser(User user);
	public boolean verifyLogin(LoginEntity le);
	public String getUsername(String email);
}
