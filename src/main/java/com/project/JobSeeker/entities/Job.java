package com.project.JobSeeker.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;
	
	@NotNull(message = "company id is mandatory")
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@NotBlank(message = "Data mandatory")
	private String title;
	
	@NotBlank(message = "Data mandatory")
	private String description;
	
	@NotNull(message = "Data mandatory")
	@Positive
	private Long salary;

	
	
	public Job() {
		super();
	}


	public Job(Long jobId, @NotNull(message = "company id is mandatory") Company company,
			@NotBlank(message = "Data mandatory") String title,
			@NotBlank(message = "Data mandatory") String description,
			@NotNull(message = "Data mandatory") @Positive Long salary) {
		super();
		this.jobId = jobId;
		this.company = company;
		this.title = title;
		this.description = description;
		this.salary = salary;
	}


	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Company getcompany() {
		return company;
	}

	public void setcompany(Company company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", company=" + company + ", title=" + title + ", description=" + description
				+ ", salary=" + salary + "]";
	}

}
