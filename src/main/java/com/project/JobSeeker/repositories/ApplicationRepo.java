package com.project.JobSeeker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.JobSeeker.entities.Application;


public interface ApplicationRepo extends JpaRepository<com.project.JobSeeker.entities.Application, Long>{

	List<Application> findByJobCompanyCompanyId(Long companyId);
	List<Application> findByUserUserId(Long id);
	boolean existsByUserUserIdAndJobJobId(Long userId, Long jobId);


}
