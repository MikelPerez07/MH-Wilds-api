package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Ailment;
import com.mpm.models.services.AilmentServiceImpl;

@RestController
@CrossOrigin(origins = ("http://localhost:4201"))
public class AilmentRestController {

	@Autowired
	private AilmentServiceImpl ailmentService;

	@GetMapping("/ailments")
	public List<Ailment> findAll() {
		return ailmentService.findAll();
	}

	@GetMapping("/ailment/{identifier}")
	public Ailment findById(@PathVariable String identifier) {

		try {
			Long id = Long.parseLong(identifier);
			return ailmentService.findById(id);

		} catch (NumberFormatException e) {
			// TODO: handle exception
			return ailmentService.findByName(identifier);
		}
	}

}
