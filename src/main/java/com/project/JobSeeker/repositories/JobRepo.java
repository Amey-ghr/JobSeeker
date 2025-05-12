package com.project.JobSeeker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.JobSeeker.entities.Job;

public interface JobRepo extends JpaRepository<Job, Long> {

	@Query("SELECT j FROM Job j WHERE j.company.companyId = :companyId")
	List<Job> findByCompanyId(@Param("companyId") Long companyId);

}
