package com.employee_skill_management.employee.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_skill")
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sno")
    private int employeeSkillId;

    @Column(name = "skill_id")
    private int skillId;

    // Getters and setters
    public int getEmployeeSkillId() {
        return employeeSkillId;
    }

    public void setEmployeeSkillId(int employeeSkillId) {
        this.employeeSkillId = employeeSkillId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
