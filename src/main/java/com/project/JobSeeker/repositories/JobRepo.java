package com.project.JobSeeker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.JobSeeker.entities.Job;

public interface JobRepo extends JpaRepository<Job, Long> {

	 List<Job> findByCompanyId(Long companyId);
}
