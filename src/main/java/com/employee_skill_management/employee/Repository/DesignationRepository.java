package com.employee_skill_management.employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_skill_management.employee.Entity.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Integer> {
	Optional<Designation> findByTitle(String designationName);
}
