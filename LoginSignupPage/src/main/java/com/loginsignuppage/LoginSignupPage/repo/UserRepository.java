package com.loginsignuppage.LoginSignupPage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginsignuppage.LoginSignupPage.entity.User;
import java.util.List;
import java.util.Optional;



public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByEmail(String email);
}
