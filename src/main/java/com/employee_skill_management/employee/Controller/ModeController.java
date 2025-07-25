package com.employee_skill_management.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_skill_management.employee.Entity.Mode;
import com.employee_skill_management.employee.Repository.ModeRepository;

@RestController
@RequestMapping("/employee-skill-management")
@CrossOrigin(origins = {
	    "https://skillmanagement.infosharesystems.io",
	    "https://api-skillmanagement.infosharesystems.io"
	})
public class ModeController {

    @Autowired
    private ModeRepository modeRepository;

    @GetMapping("/modes")
    public List<Mode> getAllModes() {
        return modeRepository.findAll();
    }
}

