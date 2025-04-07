package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Charm;
import com.mpm.models.services.IGeneralService;

@RestController
@CrossOrigin(origins = ("http://localhost:4201"))
public class CharmRestController {

	@Autowired
	private IGeneralService<Charm> charmService;

	@GetMapping("/charms")
	public List<Charm> findAll() {
		return charmService.findAll();
	}

	@GetMapping("/charm/{id}")
	public Charm findById(@PathVariable Long id) {
		return charmService.findById(id);
	}

}
