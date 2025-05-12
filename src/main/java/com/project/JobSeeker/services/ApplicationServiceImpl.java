package com.project.JobSeeker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.JobSeeker.entities.Application;
import com.project.JobSeeker.repositories.ApplicationRepo;

@Service
public class ApplicationServiceImpl implements ApplicationService{

	private final ApplicationRepo repository;

	@Autowired
	public ApplicationServiceImpl(ApplicationRepo repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public List<Application> getAllApplications() {
		return repository.findAll();
	}

	@Override
	public Application getApplicationById(Long id) {
		return repository.findById(id)
				.orElse(null);
	}

	@Override
	public Application saveApplication(Application application) {
		return repository.save(application);
	}

	@Override
	public Application deleteApplication(Long id) {
		Application application = repository.findById(id).orElse(null);
		if(application!=null) {
			repository.delete(application);
			return application;
		}
			return null;
	}
	

	@Override
	public Application updateApplication(Application application, Long id) {
		Optional<Application> optional = repository.findById(id);
		if (optional.isPresent()) {
			Application existing = optional.get();
			existing.setStatus(application.getStatus());
			return repository.save(existing);
		}
		return null;
	}

	@Override
	public List<Application> getAllApplicationByCompanyId(Long id) {
		return repository.findByJobCompanyCompanyId(id);
	}
	
	@Override
	public List<Application> getApplicationsByUserId(Long id) {
        return repository.findByUserUserId(id);
    }
}
