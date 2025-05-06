package com.project.JobSeeker.services;

import java.util.List;

import com.project.JobSeeker.dto.RegisterRequest;

import com.project.JobSeeker.entities.User;

public interface UserService {

	List<User> getAllUsers();
	User getUserById(Long id);
	User saveUser(User user);
	User updateUser(User user,Long id);
	User deleteUser(Long id);
	User registerUser(RegisterRequest registerRequest);
	Boolean emailExists(String email);
	User validateUser(String email, String password);
	
}
