package com.project.JobSeeker.controller;

import java.net.URI;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.JobSeeker.dto.LoginDTO;
import com.project.JobSeeker.dto.RegisterRequest;

import com.project.JobSeeker.entities.User;

import com.project.JobSeeker.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")

public class UserController {

	private final UserService userService;
	
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	

	
	//----------------------------------------DISPLAY_ALL--------------------------------------
	
	
	@PostMapping("/view")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	
	//----------------------------------------DISPLAY_BY_ID--------------------------------------
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User User = userService.getUserById(id);
		if (User != null) {
			return ResponseEntity.status(HttpStatus.OK).body(User);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	
	//----------------------------------------SAVE--------------------------------------
	
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User User) {
		User saved = userService.saveUser(User);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/Users/" + saved.getUserId()))
				.body(saved);
	}
	
	//----------------------------------------UPDATE--------------------------------------
	
	

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
		User updated = userService.updateUser(newUser, id);
		if (updated != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	//----------------------------------------DELETE--------------------------------------
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		User deleted = userService.deleteUser(id);
		if (deleted!=null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
