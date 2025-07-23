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

import com.employee_skill_management.employee.Entity.Location;
import com.employee_skill_management.employee.Repository.LocationRepository;

@RestController
@RequestMapping("/employee-skill-management")
@CrossOrigin(origins = "*")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;
    
    @PostMapping("/locations")
	public String newSkill(@RequestBody Location location) {
    	locationRepository.save(location);
        return "New Skill Added Successfully...!";
    }

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
    @PutMapping("/locations/{id}")
	public ResponseEntity<String> updateLocation(@PathVariable int id, @RequestBody Location updatedLocation) {
	    Optional<Location> existingLocation = locationRepository.findById(id);
	    
	    if (existingLocation.isPresent()) {
	        Location location = existingLocation.get();
	        location.setLocationName(updatedLocation.getLocationName());
	        locationRepository.save(location);
	        return ResponseEntity.ok("Location Updated Successfully...!");
	    } else {
	        return ResponseEntity.status(404).body("Skill with ID " + id + " not found!");
	    }
	}

	@DeleteMapping("/locations/{id}")
	public String deleteSkill(@PathVariable int id) {
		locationRepository.deleteById(id);
		return "Location Deleted Successfully...!";
	}
}
