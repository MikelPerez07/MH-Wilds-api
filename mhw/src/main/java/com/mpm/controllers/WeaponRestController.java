package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mpm.entities.Weapon;
import com.mpm.entities.WeaponType;
import com.mpm.entities.Views.Views;
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
	@JsonView(Views.Basic.class)
	public List<Weapon> findAll() {
		return weaponService.findAll();
	}

	@JsonView(Views.Basic.class)
	@GetMapping("weapon/{id}")
	public Weapon findById(@PathVariable Long id) {
		return weaponService.findById(id);
	}

	@GetMapping("weapon/{id}/previous")
	@JsonView(Views.previousWeapon.class) // Devuelve solo los datos de la vista 'PreviousView'
	public Weapon getPrevious(@PathVariable Long id) {
		Weapon weapon = weaponService.findById(id);
		return weapon; // Solo serializa el atributo 'previous'
	}

	@GetMapping("weapon/{id}/upgrades")
	@JsonView(Views.weaponUpgrades.class) // Devuelve solo los datos de la vista 'NextView'
	public Weapon getNext(@PathVariable Long id) {
		Weapon weapon = weaponService.findById(id);
		return weapon; // Solo serializa el atributo 'weaponUpgrades'
	}

	@JsonView(Views.Basic.class)
	@GetMapping("/weapons/{weaponType}")
	public List<Weapon> findByType(@PathVariable String weaponType) {
		weaponType = weaponType.replace("-", " ");

		WeaponType type = typeService.findByName(weaponType);
		return weaponService.findByWeaponType(type);
	}
}
