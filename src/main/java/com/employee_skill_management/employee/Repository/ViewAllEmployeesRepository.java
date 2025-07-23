package com.employee_skill_management.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee_skill_management.employee.DTO.EmployeeDTO;
import com.employee_skill_management.employee.Entity.ViewAllEmployees;

public interface ViewAllEmployeesRepository extends JpaRepository<ViewAllEmployees, Integer> {
	@Query(value = """
	        SELECT 
	            e.sno,
	            e.name,
	            e.experience,
	            c.company_name AS company,
	            d.title AS designation,
	            e.date_of_joining,
	            l.location_name AS location,
	            m.mode_name AS mode,
	            s.status_name AS status,
	            GROUP_CONCAT(DISTINCT sk.skill_name ORDER BY sk.skill_name SEPARATOR ', ') AS skills,
	            GROUP_CONCAT(DISTINCT p.project_name ORDER BY p.project_name SEPARATOR ', ') AS projects
	        FROM employee e
	        JOIN company c ON e.company = c.company_id
	        JOIN designation d ON e.designation = d.designation_id
	        JOIN location l ON e.location = l.location_id
	        JOIN mode m ON e.mode = m.mode_id
	        JOIN status s ON e.status = s.status_id
	        LEFT JOIN employee_skill es ON e.sno = es.sno
	        LEFT JOIN skill sk ON es.skill_id = sk.skill_id
	        LEFT JOIN employee_project ep ON e.sno = ep.sno
	        LEFT JOIN project p ON ep.project_id = p.project_id
	        GROUP BY e.sno, e.name, e.experience, c.company_name, d.title, e.date_of_joining, l.location_name, m.mode_name, s.status_name
	        ORDER BY e.sno
	        """, nativeQuery = true)
	    List<Object[]> getAllEmployeeDetailsRaw();
	EmployeeDTO save(EmployeeDTO dto);
}

