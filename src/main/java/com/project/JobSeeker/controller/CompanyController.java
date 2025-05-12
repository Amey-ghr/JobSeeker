package com.project.JobSeeker.controller;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.JobSeeker.entities.Company;
import com.project.JobSeeker.services.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

	private final CompanyService service;
	
	@Autowired
	public CompanyController(CompanyService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies() {
		List<Company> company = service.getAllCompanies();
		return ResponseEntity.status(HttpStatus.OK).body(company);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable Long id) {
		Company company = service.getCompanyById(id);
		if (company != null) {
			return ResponseEntity.status(HttpStatus.OK).body(company);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Company> getCompanyByUser(@PathVariable Long id) {
		Company company = service.getCompanyByUserId(id);
		if (company != null) {
			return ResponseEntity.status(HttpStatus.OK).body(company);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<Company> createCompany(@RequestBody Company Company) {
		Company saved = service.saveCompany(Company);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/company/" + saved.getCompanyId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company newCompany) {
		Company updated = service.updateCompany(newCompany, id);
		if (updated != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
		Company deleted = service.deleteCompany(id);
		if (deleted!=null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}


