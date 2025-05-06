package com.project.JobSeeker.services;

import java.util.List;

import com.project.JobSeeker.entities.Application;

public interface ApplicationService {

	List<Application>getAllApplications();
	Application getApplicationById(Long id);
	Application saveApplication(Application application);
	Application deleteApplication(Long id);
	Application updateApplication(Application application, Long id);
}
