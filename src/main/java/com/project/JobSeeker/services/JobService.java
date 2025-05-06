package com.project.JobSeeker.services;

import java.util.List;

import com.project.JobSeeker.entities.Job;

public interface JobService {

	List<Job>getAllJobs();
	Job getJobById(Long id);
	Job saveJob(Job job);
	Job deleteJob(Long id);
	Job updateJob(Job job, Long id);
}
