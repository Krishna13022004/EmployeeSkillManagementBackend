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

import com.employee_skill_management.employee.Entity.Skill;
import com.employee_skill_management.employee.Repository.SkillRepo;

@RestController
@RequestMapping("/employee-skill-management")
@CrossOrigin(origins = "*")
public class SkillController {
	
	@Autowired
	private SkillRepo repo;
	
	@PostMapping("/skills")
	public String newSkill(@RequestBody Skill skill) {
        repo.save(skill);
        return "New Skill Added Successfully...!";
    }
	
	@GetMapping("/skills")
	public List<Skill> getAllSkills(){
		return repo.findAll();
	}

	@PutMapping("/skills/{id}")
	public ResponseEntity<String> updateSkill(@PathVariable int id, @RequestBody Skill updatedSkill) {
	    Optional<Skill> existingSkill = repo.findById(id);
	    
	    if (existingSkill.isPresent()) {
	        Skill skill = existingSkill.get();
	        skill.setSkill_name(updatedSkill.getSkill_name());
	        repo.save(skill);
	        return ResponseEntity.ok("Skill Updated Successfully...!");
	    } else {
	        return ResponseEntity.status(404).body("Skill with ID " + id + " not found!");
	    }
	}

	@DeleteMapping("/skills/{id}")
	public String deleteSkill(@PathVariable int id) {
		repo.deleteById(id);
		return "Skill Deleted Successfully...!";
	}

}
