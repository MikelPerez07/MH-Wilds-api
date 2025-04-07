package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Weapon;
import com.mpm.entities.WeaponType;
import com.mpm.models.services.IGeneralNameService;
import com.mpm.models.services.IWeaponService;

@RestController
@CrossOrigin(origins = ("http://localhost:4201"))
public class WeaponRestController {

	@Autowired
	private IWeaponService weaponService;

	@Autowired
	private IGeneralNameService<WeaponType> typeService;

	@GetMapping("weapons")
	public List<Weapon> findAll() {
		return weaponService.findAll();
	}

	@GetMapping("weapon/{id}")
	public Weapon findById(@PathVariable Long id) {
		return weaponService.findById(id);
	}

	@GetMapping("/weapons/{weaponType}")
	public List<Weapon> findByType(@PathVariable String weaponType) {
		weaponType = weaponType.replace("-", " ");

		WeaponType type = typeService.findByName(weaponType);
		return weaponService.findByWeaponType(type);
	}
}
