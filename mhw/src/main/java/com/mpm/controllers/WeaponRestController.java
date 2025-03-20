package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Weapon;
import com.mpm.models.services.IGeneralService;

@RestController
public class WeaponRestController {

	@Autowired
	private IGeneralService<Weapon> weaponService;

	@GetMapping("weapons")
	public List<Weapon> findAll() {
		return weaponService.findAll();
	}

	@GetMapping("weapon/{id}")
	public Weapon findById(@PathVariable Long id) {
		return weaponService.findById(id);
	}
}
