package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.MotionValue;
import com.mpm.entities.WeaponType;
import com.mpm.models.services.IMotionValueService;

@RestController
@RequestMapping("motion-values")
public class MotionValueRestController {

	@Autowired
	private IMotionValueService<MotionValue> motionValueService;

	@GetMapping
	public List<MotionValue> findAll() {
		return motionValueService.findAll();
	}

	@GetMapping("/{idMotionValue}")
	public MotionValue findById(@PathVariable Long idMotionValue) {

		return motionValueService.findById(idMotionValue);
	}

	@GetMapping("/{weaponType}")
	public List<MotionValue> findByType(@PathVariable WeaponType weaponType) {

		return motionValueService.findByWeaponType(weaponType);
	}

	@GetMapping("/{name}")
	public MotionValue findByName(@PathVariable String name) {
		return motionValueService.findByName(name);
	}

}
