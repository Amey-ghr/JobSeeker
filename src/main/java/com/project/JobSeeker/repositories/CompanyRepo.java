package com.project.JobSeeker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.JobSeeker.entities.Company;

public interface CompanyRepo extends JpaRepository<Company, Long>{

	Company findByUserUserId(Long userId);
}
