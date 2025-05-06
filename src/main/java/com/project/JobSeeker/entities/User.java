package com.project.JobSeeker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotBlank(message = "Data mandatory")
	private String name;

	@NotBlank(message = "Data mandatory")
	private String email;

	@NotBlank(message = "Data mandatory")
	private String password;

	@NotBlank(message = "Data mandatory")
	private String resume;

	@NotBlank(message = "Data mandatory")
	private String phone;

	@NotBlank(message = "Data mandatory")
	private String userType;

	public User() {
		super();
	}

	public User(Long userId, @NotBlank(message = "Data mandatory") String name,
			@NotBlank(message = "Data mandatory") String email, @NotBlank(message = "Data mandatory") String password,
			@NotBlank(message = "Data mandatory") String resume, @NotBlank(message = "Data mandatory") String phone,
			@NotBlank(message = "Data mandatory") String userType) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.resume = resume;
		this.phone = phone;
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", resume="
				+ resume + ", phone=" + phone + ", userType=" + userType + "]";
	}

	public Long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
