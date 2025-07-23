package com.employee_skill_management.employee.DTO;

import java.time.LocalDate;
import java.util.Map;

public class EmployeeDTO {
	private int sno;
	private String name;
	private String company;
    private String location;
    private int experience;
    private LocalDate joining_date;
    private String status;
    private String mode;
    private Map<String, String> skills;
    private Map<String, String> projects;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public LocalDate getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(LocalDate joining_date) {
		this.joining_date = joining_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	 public Map<String, String> getSkills() {
	        return skills;
	    }

	    public void setSkills(Map<String, String> skills) {
	        this.skills = skills;
	    }

	    public Map<String, String> getProjects() {
	        return projects;
	    }

	    public void setProjects(Map<String, String> projects) {
	        this.projects = projects;
	    }
	}
