package com.employee_skill_management.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_skill_management.employee.Entity.Skill;

@Repository
public interface SkillRepo extends JpaRepository<Skill, Integer> {

}
