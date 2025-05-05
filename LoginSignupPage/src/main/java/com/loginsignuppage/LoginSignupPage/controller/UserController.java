package com.loginsignuppage.LoginSignupPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loginsignuppage.LoginSignupPage.entity.LoginEntity;
import com.loginsignuppage.LoginSignupPage.entity.User;
import com.loginsignuppage.LoginSignupPage.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService us;
	
	
	
	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String showSignupPage() {
		return "signup";
	}

	@GetMapping("/home")
	public String showHomePage(HttpSession session, Model model) {
		LoginEntity user = (LoginEntity) session.getAttribute("LoggedInUser");
		
//		System.out.println("user: "+user);
		
	    if (user == null) {
	        return "redirect:/?logintip=true";
	    }
	    return "home";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("loginEmail") String loginEmail,@RequestParam("loginPassword") String loginPassword,Model model, HttpSession httpSession) {
		
		LoginEntity loginDto=new LoginEntity();
		loginDto.setLoginEmail(loginEmail);
		loginDto.setLoginPassword(loginPassword);
		boolean isValid=us.verifyLogin(loginDto);
		if(isValid) {
			httpSession.setAttribute("LoggedInUser", loginDto);
			String uname=us.getUsername(loginEmail);
			
//			System.out.println(uname);
			
			model.addAttribute("user",uname);
			return "home";
		}
		model.addAttribute("error", "Invalid username or password");
        return "login";
	}
	
	
	@PostMapping("/signup")
	public String signupUser(@RequestParam("signupEmail") String signupEmail,@RequestParam("signupUsername") String signupUsername,@RequestParam("signupPassword") String signupPassword) {
		
		User userDto=new User();
		userDto.setEmail(signupEmail);
		userDto.setUsername(signupUsername);
		userDto.setPassword(signupPassword);
		us.addUser(userDto);
		return "redirect:/?signup=true";
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false); // Get session if exists

	    session.invalidate(); // Destroys session
	    

	    // Optional: Clear cache to prevent browser from accessing back pages
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    
	    return "redirect:/?logout=true";
	}
	
}
