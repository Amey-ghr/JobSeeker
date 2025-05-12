package com.project.JobSeeker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.JobSeeker.dto.CompanyDTO;
import com.project.JobSeeker.dto.RegisterRequest;
import com.project.JobSeeker.entities.Company;
import com.project.JobSeeker.entities.User;
import com.project.JobSeeker.repositories.CompanyRepo;
import com.project.JobSeeker.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepo repository;
	private final CompanyRepo companyRepository;

	@Autowired
	public UserServiceImpl(UserRepo repository,CompanyRepo companyRepository) {
		super();
		this.repository = repository;
		this.companyRepository= companyRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return repository.findById(id)
				.orElse(null);
	}

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public User updateUser(User user, Long id) {
		Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			User existing = optional.get();
			existing.setName(user.getName());
			existing.setEmail(user.getEmail());
			existing.setPassword(user.getPassword());
			existing.setPhone(user.getPhone());
			existing.setResume(user.getResume());
			existing.setUserType(user.getUserType());
			return repository.save(existing);
		}
		return null;
	}

	@Override
	public User deleteUser(Long id) {
		User user = repository.findById(id).orElse(null);
		if(user!=null) {
			repository.delete(user);
			return user;
		}
			return null;
	}
	
	 public User registerUser(RegisterRequest req) {
	        User user = new User();
	        user.setName(req.getName());
	        user.setEmail(req.getEmail());
	        user.setPassword(req.getPassword());
	        user.setPhone(req.getPhone());
	        user.setResume(req.getResume()); 
	        user.setUserType(req.getUserType());

	        User savedUser = repository.save(user);

	        if ("Employer".equalsIgnoreCase(req.getUserType())) {
	            CompanyDTO dto = req.getCompany();
	            Company company = new Company();
	            company.setName(dto.getName());
	            company.setLocation(dto.getLocation());
	            company.setIndustry(dto.getIndustry());
	            company.setUser(savedUser); 
	            companyRepository.save(company);
	        }

	        return savedUser;
	    }
	 
	 @Override
	public User validateUser(String email, String password) {
		User user = repository.findByEmail(email).orElse(null);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
			else 
				return null;
		}
		else
			return null;
	}
	 
	
	@Override
	public Boolean emailExists(String email) {
		return repository.existsByEmail(email);
	}
	

}
