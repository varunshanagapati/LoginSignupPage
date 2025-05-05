package com.loginsignuppage.LoginSignupPage.entity;


import jakarta.persistence.*;

//This is created for JPA repository to store data

@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	private String email;
	
	private String username;
	private String Password;
	public String getUsername() {
		return username;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", Password=" + Password + "]";
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
