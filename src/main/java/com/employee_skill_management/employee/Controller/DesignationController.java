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

import com.employee_skill_management.employee.Entity.Designation;
import com.employee_skill_management.employee.Repository.DesignationRepository;

@RestController
@RequestMapping("/employee-skill-management")
@CrossOrigin(origins = "*")
public class DesignationController {

    @Autowired
    private DesignationRepository designationRepository;
    
    @PostMapping("/designations")
    public String newDesignation(@RequestBody Designation newDesignation) {
    	designationRepository.save(newDesignation);
    	return "New Designation Added Successfully...!";
    }

    @GetMapping("/designations")
    public List<Designation> getAllDesignations() {
        return designationRepository.findAll();
    }
    
    @PutMapping("/designations/{id}")
	public ResponseEntity<String> updateDesignation(@PathVariable int id, @RequestBody Designation updatedDesignation) {
	    Optional<Designation> existingDesignation = designationRepository.findById(id);
	    
	    if (existingDesignation.isPresent()) {
	        Designation designation = existingDesignation.get();
	        designation.setTitle(updatedDesignation.getTitle());
	        designationRepository.save(designation);
	        return ResponseEntity.ok("Designation Updated Successfully...!");
	    } else {
	        return ResponseEntity.status(404).body("Designation with ID " + id + " not found!");
	    }
	}
    
    @DeleteMapping("/designations/{id}")
    public String deleteDesignation(@PathVariable int id) {
    	designationRepository.deleteById(id);
    	return "Designation deleted Successfully...!";
    }
}
