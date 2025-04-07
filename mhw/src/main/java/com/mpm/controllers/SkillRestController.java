package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Skill;
import com.mpm.models.services.IGeneralService;

@RestController
@CrossOrigin(origins = ("http://localhost:4201"))
public class SkillRestController {

	@Autowired
	private IGeneralService<Skill> skillService;

	@GetMapping("/skills")
	public List<Skill> findAll() {
		return skillService.findAll();
	}

	@GetMapping("/skill/{id}")
	public Skill findById(@PathVariable Long id) {
		return skillService.findById(id);
	}

}
