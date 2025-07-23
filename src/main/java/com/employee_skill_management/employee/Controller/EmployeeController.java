package com.employee_skill_management.employee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_skill_management.employee.DTO.EmployeeDTO;
import com.employee_skill_management.employee.DTO.EmployeeService;
import com.employee_skill_management.employee.Entity.ViewAllEmployees;
import com.employee_skill_management.employee.Repository.ViewAllEmployeesRepository;

@RestController
@RequestMapping("/employee-skill-management")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private ViewAllEmployeesRepository viewAllEmployeesRepository;
    
    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping("/employees")
    public String newEmployee(@RequestBody ViewAllEmployees employee) {
    	viewAllEmployeesRepository.save(employee);
    	return "New Employee Registered Successfully";    	
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> viewAllEmployees() {
        return ResponseEntity.ok(employeeService.viewAllEmployees());
    }
    
    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody ViewAllEmployees updatedEmp) {
        Optional<ViewAllEmployees> existingEmpOpt = viewAllEmployeesRepository.findById(id);

        if (existingEmpOpt.isPresent()) {
            ViewAllEmployees emp = existingEmpOpt.get();
            emp.setName(updatedEmp.getName());
            emp.setCompany(updatedEmp.getCompany());
            emp.setLocation(updatedEmp.getLocation());
            emp.setExperience(updatedEmp.getExperience());
            emp.setJoining_date(updatedEmp.getJoining_date());
            emp.setStatus(updatedEmp.getStatus());
            emp.setDesignation(updatedEmp.getDesignation());

            viewAllEmployeesRepository.save(emp);
            return "Employee Updated Successfully...!";
        } else {
            return "Employee Not Found!";
        }
    }
    
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
    	viewAllEmployeesRepository.deleteById(id);
    	return "Employee Deleted Successfully...!";
    }
}
