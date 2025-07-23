package com.employee_skill_management.employee.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_skill_management.employee.Entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	Optional<Company> findByCompanyName(String companyName);
}
