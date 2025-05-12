package com.project.JobSeeker.services;

import java.util.List;

import com.project.JobSeeker.entities.Company;
import com.project.JobSeeker.entities.User;

public interface CompanyService {

	List<Company>getAllCompanies();
	Company getCompanyById(Long id);
	Company saveCompany(Company company);
	Company deleteCompany(Long id);
	Company updateCompany(Company company, Long id);
	Company getCompanyByUserId(Long id); 
}
