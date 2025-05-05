package com.loginsignuppage.LoginSignupPage.entity;

public class LoginEntity {

	
	private String loginEmail;
	private String loginPassword;
	
	
	public String getLoginEmail() {
		return loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	@Override
	public String toString() {
		return "LoginEntity [loginEmail=" + loginEmail + ", loginPassword=" + loginPassword + "]";
	}
	
	
}
