package com.loginsignuppage.LoginSignupPage.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginsignuppage.LoginSignupPage.entity.LoginEntity;
import com.loginsignuppage.LoginSignupPage.entity.User;
import com.loginsignuppage.LoginSignupPage.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public String addUser(User user) {
		User u1=new User();
		u1.setEmail(user.getEmail());
		u1.setPassword(passwordEncoder.encode(user.getPassword()));
		u1.setUsername(user.getUsername());
		userRepo.save(u1);
		return u1.toString();
	}

	@Override
	public boolean verifyLogin(LoginEntity le) {
		Optional<User> userOptional = userRepo.findByEmail(le.getLoginEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return passwordEncoder.matches(le.getLoginPassword(), user.getPassword());
        }
        return false;
	}

	@Override
	public String getUsername(String email) {
		
		return userRepo.findByEmail(email).get().getUsername();
		
		
	}


	
}
