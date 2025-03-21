package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Location;
import com.mpm.models.services.IGeneralService;

@RestController
public class LocationRestController {

	@Autowired
	private IGeneralService<Location> locationService;

	@GetMapping("locations")
	public List<Location> findAll() {
		return locationService.findAll();
	}

	@GetMapping("location/{id}")
	public Location findById(@PathVariable Long id) {
		return locationService.findById(id);
	}

}
