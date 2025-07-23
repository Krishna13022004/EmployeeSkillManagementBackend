package com.employee_skill_management.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_skill_management.employee.Entity.Mode;

public interface ModeRepository extends JpaRepository<Mode, Integer> {
}
