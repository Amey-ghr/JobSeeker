package com.project.JobSeeker.services;

import java.util.List;

import com.project.JobSeeker.entities.Company;

public interface CompanyService {

	List<Company>getAllCompanies();
	Company getCompanyById(Long id);
	Company saveCompany(Company company);
	Company deleteCompany(Long id);
	Company updateCompany(Company company, Long id);
}
