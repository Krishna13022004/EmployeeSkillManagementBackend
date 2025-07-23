package com.employee_skill_management.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_skill_management.employee.Entity.EmployeeSkill;
import com.employee_skill_management.employee.Repository.EmployeeSkillRepository;

@RestController
@RequestMapping("/employee-skill-management")
@CrossOrigin(origins = {
	    "https://skillmanagement.infosharesystems.io",
	    "https://api-skillmanagement.infosharesystems.io"
	})
public class EmployeeSkillController {

	@Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @GetMapping("/employeeskills")
    public List<EmployeeSkill> getAllEmployeeSkills() {
        return employeeSkillRepository.findAll();
    }
}
