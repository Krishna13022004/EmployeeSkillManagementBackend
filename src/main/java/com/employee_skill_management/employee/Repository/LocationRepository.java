package com.employee_skill_management.employee.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_skill_management.employee.Entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	Optional<Location> findByLocationName(String locationName);
}
