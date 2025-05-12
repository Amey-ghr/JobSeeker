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

import com.project.JobSeeker.entities.Application;
import com.project.JobSeeker.repositories.ApplicationRepo;
import com.project.JobSeeker.services.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationsController {

	private final ApplicationService service;
	private final ApplicationRepo applicationRepo;
	
	@Autowired
	public ApplicationsController(ApplicationService service, ApplicationRepo applicationRepo) {
		this.service = service;
		this.applicationRepo=applicationRepo;
	}
	
	@GetMapping
	public ResponseEntity<List<Application>> getAllApplications() {
		List<Application> applications = service.getAllApplications();
		return ResponseEntity.status(HttpStatus.OK).body(applications);
	}
	
	 @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Application>> getApplicationsByUserId(@PathVariable Long userId) {
	        List<Application> applications = service.getApplicationsByUserId(userId);
	        return ResponseEntity.ok(applications);
	    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Application> getApplication(@PathVariable Long id) {
		Application application = service.getApplicationById(id);
		if (application != null) {
			return ResponseEntity.status(HttpStatus.OK).body(application);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<List<Application>> getApplicationByCompany(@PathVariable Long id) {
		List<Application> application = service.getAllApplicationByCompanyId(id);
		if (application != null) {
			return ResponseEntity.status(HttpStatus.OK).body(application);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<Application> createApplication(@RequestBody Application application) {
	    boolean alreadyApplied = applicationRepo.existsByUserUserIdAndJobJobId(application.getUserId(), application.getJobId());
	    
	    if (alreadyApplied) {
	        return ResponseEntity
	            .status(HttpStatus.CONFLICT)
	            .build();
	    }
	    
		Application saved = service.saveApplication(application);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Application> updateApplication(@PathVariable Long id, @RequestBody Application newApplication) {
		Application updated = service.updateApplication(newApplication, id);
		if (updated != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
		Application deleted = service.deleteApplication(id);
		if (deleted!=null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}


