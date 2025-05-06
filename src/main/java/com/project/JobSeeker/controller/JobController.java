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

import com.project.JobSeeker.entities.Job;
import com.project.JobSeeker.services.JobService;


@RestController
@RequestMapping("/api/jobs")
public class JobController {
	private final JobService service;
	
	@Autowired
	public JobController(JobService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Job>> getAllJobs() {
		List<Job> jobs = service.getAllJobs();
		return ResponseEntity.status(HttpStatus.OK).body(jobs);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJob(@PathVariable Long id) {
		Job job = service.getJobById(id);
		if (job != null) {
			return ResponseEntity.status(HttpStatus.OK).body(job);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<Job> createJob(@RequestBody Job job) {
		Job saved = service.saveJob(job);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/Jobs/" + saved.getJobId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job newJob) {
		Job updated = service.updateJob(newJob, id);
		if (updated != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
		Job deleted = service.deleteJob(id);
		if (deleted!=null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
