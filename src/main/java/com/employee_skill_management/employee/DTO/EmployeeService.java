package com.employee_skill_management.employee.DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_skill_management.employee.Repository.ViewAllEmployeesRepository;

@Service
public class EmployeeService {

    @Autowired
    private ViewAllEmployeesRepository employeeRepository;

    public List<EmployeeDTO> viewAllEmployees() {
        List<Object[]> results = employeeRepository.getAllEmployeeDetailsRaw();
        List<EmployeeDTO> employees = new ArrayList<>();

        for (Object[] row : results) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setSno((Integer) row[0]);
            dto.setName((String) row[1]);
            dto.setExperience((Integer) row[2]);
            dto.setCompany((String) row[3]);
            dto.setJoining_date(((Date) row[5]).toLocalDate());
            dto.setLocation((String) row[6]);
            dto.setMode((String) row[7]);
            dto.setStatus((String) row[8]);
            if (row[9] != null && !((String) row[9]).isBlank()) {
                String[] skillArray = ((String) row[9]).split(",");
                Map<String, String> skillMap = new LinkedHashMap<>();
                for (int i = 0; i < skillArray.length; i++) {
                    skillMap.put("skill" + (i + 1), skillArray[i].trim());
                }
                dto.setSkills(skillMap);
            } else {
                dto.setSkills(new LinkedHashMap<>());
            }

            // PROJECTS
            if (row[10] != null && !((String) row[10]).isBlank()) {
                String[] projectArray = ((String) row[10]).split(",");
                Map<String, String> projectMap = new LinkedHashMap<>();
                for (int i = 0; i < projectArray.length; i++) {
                    projectMap.put("project" + (i + 1), projectArray[i].trim());
                }
                dto.setProjects(projectMap);
            } else {
                dto.setProjects(new LinkedHashMap<>());
            }

            employees.add(dto);
        }

        return employees;
    }
}