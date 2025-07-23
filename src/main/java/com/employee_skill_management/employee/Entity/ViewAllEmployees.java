package com.employee_skill_management.employee.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class ViewAllEmployees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sno") 
    private int sno;
    @Column
    private String name;
    @Column
    private int company;
    @Column
    private int location;
    @Column
    private int experience;
    @Column(name = "date_of_joining")
    private LocalDate date_of_joining;
    @Column
    private int status;
  
    @Column
    private int designation;
    @Column
    private int mode;

    // Getters and Setters

    public int getEmployee_id() {
        return sno;
    }

    public void setEmployee_id(int employee_id) {
        this.sno = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public LocalDate getJoining_date() {
        return date_of_joining;
    }

    public void setJoining_date(LocalDate joining_date) {
        this.date_of_joining = joining_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    public int getDesignation() {
        return designation;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }
	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
}
