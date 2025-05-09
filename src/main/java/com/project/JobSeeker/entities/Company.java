package com.project.JobSeeker.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;

	@NotNull(message = "user id is mandatory")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	@NotBlank(message = "Data mandatory")
	private String name;
	@NotBlank(message = "Data mandatory")
	private String industry;
	@NotBlank(message = "Data mandatory")
	private String location;

	public Company() {
		super();
	}

	public Company(Long companyId, @NotNull(message = "user id is mandatory") User user,
			@NotBlank(message = "Data mandatory") String name, @NotBlank(message = "Data mandatory") String industry,
			@NotBlank(message = "Data mandatory") String location) {
		super();
		this.companyId = companyId;
		this.user = user;
		this.name = name;
		this.industry = industry;
		this.location = location;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", industry=" + industry + ", location="
				+ location + "]";
	}

}
