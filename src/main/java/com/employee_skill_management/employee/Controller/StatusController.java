package com.employee_skill_management.employee.Controller;

import com.employee_skill_management.employee.Entity.Status;
import com.employee_skill_management.employee.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-skill-management")
@CrossOrigin(origins = "*")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/status")
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }
}

