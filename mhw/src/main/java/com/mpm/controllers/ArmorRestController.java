package com.mpm.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Armor;
import com.mpm.models.services.IGeneralService;

@RestController
public class ArmorRestController {

	@Autowired
	private IGeneralService<Armor> armorService;

	@GetMapping("/armors")
	public List<Armor> findAll() {
		return armorService.findAll();
	}

	@GetMapping("/armor/{id}")
	public Map<String, Object> findById(@PathVariable Long id) {
		Armor armor = armorService.findById(id);
		Map<String, Object> filteredArmor = new HashMap<>();

		filteredArmor.put(null, filteredArmor);

		return armorService.findById(id).filterArmor();
	}

}
