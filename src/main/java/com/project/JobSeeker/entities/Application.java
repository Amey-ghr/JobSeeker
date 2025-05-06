package com.project.JobSeeker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appId;
	
	@NotNull(message = "job id is mandatory")
	private Long jobId;
	
	@NotNull(message = "company id is mandatory")
	private Long companyId;
	
	@NotBlank(message = "Data mandatory")
	private String applyDate;
	
	@NotBlank(message = "Data mandatory")
	private String status;

	
	
	public Application() {
		super();
	}

	public Application(Long appId, @NotNull(message = "job id is mandatory") Long jobId,
			@NotNull(message = "company id is mandatory") Long companyId,
			@NotBlank(message = "Data mandatory") String applyDate,
			@NotBlank(message = "Data mandatory") String status) {
		super();
		this.appId = appId;
		this.jobId = jobId;
		this.companyId = companyId;
		this.applyDate = applyDate;
		this.status = status;
	}

	public Long getAppId() {
		return appId;
	}

	public Long getJobId() {
		return jobId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", jobId=" + jobId + ", companyId=" + companyId + ", applyDate="
				+ applyDate + ", status=" + status + "]";
	}

}
