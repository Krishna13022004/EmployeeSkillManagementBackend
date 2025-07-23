package com.employee_skill_management.employee.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_skill_management.employee.Entity.Status;


public interface StatusRepository extends JpaRepository<Status, Integer> {
	Optional<Status> findByStatusName(String statusName);
}
