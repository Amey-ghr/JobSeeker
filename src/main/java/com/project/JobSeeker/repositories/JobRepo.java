package com.project.JobSeeker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.JobSeeker.entities.Job;

public interface JobRepo extends JpaRepository<Job, Long> {

}
