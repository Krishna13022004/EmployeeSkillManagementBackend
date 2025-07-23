package com.employee_skill_management.employee.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_project")
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sno")
    private int empProjId;

    @Column(name = "project_id")
    private int projectId;

    // Getters and setters
    public int getEmpProjId() {
        return empProjId;
    }

    public void setEmpProjId(int empProjId) {
        this.empProjId = empProjId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
