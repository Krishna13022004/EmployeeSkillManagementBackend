package com.employee_skill_management.employee.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_skill_management.employee.Entity.EmployeeProject;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Integer> {
}
