package com.employee_skill_management.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_skill_management.employee.Entity.EmployeeSkill;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Integer> {
}
