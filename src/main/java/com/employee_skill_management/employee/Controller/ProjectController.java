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

import com.employee_skill_management.employee.Entity.Project;
import com.employee_skill_management.employee.Repository.ProjectRepository;

@RestController
@RequestMapping("/employee-skill-management")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    
    @PostMapping("/projects")
    public String newProject(@RequestBody Project project) {
    	projectRepository.save(project);
    	return "New Project added Successfully...!";
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    
    @PutMapping("/projects/{id}")
	public ResponseEntity<String> updateproject(@PathVariable int id, @RequestBody Project updatedProject) {
	    Optional<Project> existingProject = projectRepository.findById(id);
	    
	    if (existingProject.isPresent()) {
	        Project project = existingProject.get();
	        project.setProjectName(updatedProject.getProjectName());
	        projectRepository.save(project);
	        return ResponseEntity.ok("Skill Updated Successfully...!");
	    } else {
	        return ResponseEntity.status(404).body("Skill with ID " + id + " not found!");
	    }
	}
    
    @DeleteMapping("/projects/{id}")
    public String deleteProject(@PathVariable int id) {
    	projectRepository.deleteById(id);
    	return "Project Deleted Successfully...!";
    }
}
