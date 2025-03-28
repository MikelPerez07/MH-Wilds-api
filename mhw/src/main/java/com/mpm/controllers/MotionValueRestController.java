package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.MotionValue;
import com.mpm.entities.WeaponType;
import com.mpm.models.services.IGeneralNameService;
import com.mpm.models.services.IMotionValueService;

@RestController
@RequestMapping("/motion-values")
public class MotionValueRestController {

	@Autowired
	private IMotionValueService<MotionValue> motionValueService;

	@Autowired
	private IGeneralNameService<WeaponType> weaponTypeService;

	@GetMapping
	public List<MotionValue> findAll() {
		return motionValueService.findAll();
	}

	@GetMapping("/{idMotionValue}")
	public MotionValue findById(@PathVariable Long idMotionValue) {

		MotionValue motionValue = motionValueService.findById(idMotionValue);
		motionValue.setId((long) 1);
		return motionValue;
	}

	@GetMapping("/weapon-type/{weaponType}")
	public List<MotionValue> findByType(@PathVariable String weaponType) {
		WeaponType type = weaponTypeService.findByName(weaponType);
		return motionValueService.findByWeaponType(type);
	}

	@GetMapping("/name/{name}")
	public MotionValue findByName(@PathVariable String name) {
		return motionValueService.findByName(name);
	}

	@PostMapping
	public MotionValue create(@RequestBody MotionValue motionValue) {

		return motionValueService.save(motionValue);
	}

	@DeleteMapping("/{idMotionValue}")
	public void deleteById(@PathVariable Long idMotionValue) {
		motionValueService.deleteById(idMotionValue);
	}
}
