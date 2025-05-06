package com.project.JobSeeker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.JobSeeker.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);
	Optional<User> findByEmail(String email);


}
