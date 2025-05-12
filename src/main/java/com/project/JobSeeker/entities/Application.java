package com.project.JobSeeker.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appId;

	@NotNull(message = "job id is mandatory")
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	@NotNull(message = "user id is mandatory")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull(message = "Data mandatory")
	private LocalDate applyDate;

	@NotBlank(message = "Data mandatory")
	private String status;

	public Application() {
		super();
	}

	public Application(Long appId, @NotNull(message = "job id is mandatory") Job job,
			@NotNull(message = "company id is mandatory") User user,
			@NotBlank(message = "Data mandatory") LocalDate applyDate,
			@NotBlank(message = "Data mandatory") String status) {
		super();
		this.appId = appId;
		this.job = job;
		this.user = user;
		this.applyDate = applyDate;
		this.status = status;
	}


	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public Job getJob() {
		return job;
	}

	public Long getJobId() {
		return this.job.getJobId();
	}
	public void setJob(Job job) {
		this.job = job;
	}

	public User getUser() {
		return user;
	}

	public Long getUserId() {
		return this.user.getUserId();
	}
	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDate applyDate) {
		this.applyDate = applyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", jobId=" + job + ", userId=" + user + ", applyDate=" + applyDate
				+ ", status=" + status + "]";
	}

}
