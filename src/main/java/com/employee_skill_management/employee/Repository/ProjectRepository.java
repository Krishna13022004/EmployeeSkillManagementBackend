package com.employee_skill_management.employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_skill_management.employee.Entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	Optional<Project> findByProjectName(String projectName);

}
