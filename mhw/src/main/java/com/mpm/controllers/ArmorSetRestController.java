package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.ArmorSet;
import com.mpm.models.services.IGeneralService;

@RestController
@RequestMapping("/armor")
@CrossOrigin(origins = ("http://localhost:4201"))
public class ArmorSetRestController {

	@Autowired
	private IGeneralService<ArmorSet> setService;

	@GetMapping("/sets")
	public List<ArmorSet> findAll() {
		return setService.findAll();
	}

	@GetMapping("/set/{id}")
	public ArmorSet findById(@PathVariable Long id) {
		return setService.findById(id);
	}
}
