package com.project.JobSeeker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.JobSeeker.entities.Job;
import com.project.JobSeeker.repositories.JobRepo;

@Service
public class JobServiceImpl implements JobService{

	private final JobRepo repository;

	@Autowired
	public JobServiceImpl(JobRepo repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public List<Job> getAllJobsByCompany(Long id) {
		return repository.findByCompanyId(id);
	}
	
	@Override
	public List<Job> getAllJobs() {
		return repository.findAll();
	}

	@Override
	public Job getJobById(Long id) {
		return repository.findById(id)
				.orElse(null);
	}

	@Override
	public Job saveJob(Job job) {
		return repository.save(job);
	}

	@Override
	public Job deleteJob(Long id) {
		Job job = repository.findById(id).orElse(null);
		if(job!=null) {
			repository.delete(job);
			return job;
		}
			return null;
	}

	@Override
	public Job updateJob(Job job, Long id) {
		Optional<Job> optional = repository.findById(id);
		if (optional.isPresent()) {
			Job existing = optional.get();
			
			existing.setDescription(job.getDescription());
			existing.setSalary(job.getSalary());
			existing.setTitle(job.getTitle());
			return repository.save(existing);
		}
		return null;
	}

}
