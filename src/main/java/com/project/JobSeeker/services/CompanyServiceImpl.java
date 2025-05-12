package com.project.JobSeeker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.JobSeeker.entities.Company;
import com.project.JobSeeker.entities.User;
import com.project.JobSeeker.repositories.CompanyRepo;

@Service
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepo repository;

	@Autowired
	public CompanyServiceImpl(CompanyRepo repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Company> getAllCompanies() {
		return repository.findAll();
	}

	@Override
	public Company getCompanyById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Company saveCompany(Company company) {
		return repository.save(company);
	}

	@Override
	public Company deleteCompany(Long id) {
		Company company = repository.findById(id).orElse(null);
		if (company != null) {
			repository.delete(company);
			return company;
		}
		return null;
	}

	@Override
	public Company updateCompany(Company company, Long id) {
		Optional<Company> optional = repository.findById(id);
		if (optional.isPresent()) {
			Company existing = optional.get();
			existing.setName(company.getName());
			existing.setIndustry(company.getIndustry());
			existing.setLocation(company.getLocation());
			return repository.save(existing);
		}
		return null;
	}
	
	@Override
	public Company getCompanyByUserId(Long id) {
		return repository.findByUserUserId(id);
	}

}
