package com.project.JobSeeker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.JobSeeker.dto.LoginDTO;
import com.project.JobSeeker.dto.RegisterRequest;
import com.project.JobSeeker.entities.User;
import com.project.JobSeeker.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserService userService;
	
	
	@Autowired
	public AuthController(UserService userService) {
		this.userService = userService;
	}
//----------------------------------------REGISTER--------------------------------------
	
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        if (userService.emailExists(registerRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        
        userService.registerUser(registerRequest);
        return ResponseEntity.status(HttpStatus.OK).body("User registered successfully");
    }
    
    

    //----------------------------------------LOGIN--------------------------------------
      
  	@PostMapping("/login")
  	public ResponseEntity<User> loginUser(@RequestBody LoginDTO loginDTO ){
  		if (!userService.emailExists(loginDTO.getUsername())) {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          }
  		User user = userService.validateUser(loginDTO.getUsername(), loginDTO.getPassword());
  		if(user!=null)
  		return ResponseEntity.status(HttpStatus.OK).body(user);
  		else
  			return null;
  	}
  	
  	
}
