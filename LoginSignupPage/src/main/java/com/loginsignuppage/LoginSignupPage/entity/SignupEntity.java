package com.loginsignuppage.LoginSignupPage.entity;

public class SignupEntity {
	
	private String signupUsername;
	private String signupEmail;
	private String signupPassword;
	
	public String getSignupUsername() {
		return signupUsername;
	}
	public void setSignupUsername(String signupUsername) {
		this.signupUsername = signupUsername;
	}
	public String getSignupEmail() {
		return signupEmail;
	}
	public void setSignupEmail(String signupEmail) {
		this.signupEmail = signupEmail;
	}
	public String getSignupPassword() {
		return signupPassword;
	}
	public void setSignupPassword(String signupPassword) {
		this.signupPassword = signupPassword;
	}
	
	@Override
	public String toString() {
		return "SignupEntity [signupUsername=" + signupUsername + ", signupEmail=" + signupEmail + ", signupPassword="
				+ signupPassword + "]";
	}
	
}
