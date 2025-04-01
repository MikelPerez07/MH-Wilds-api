package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mpm.entities.Monster;
import com.mpm.entities.Views.Views;
import com.mpm.models.services.IGeneralNameService;

@RestController
public class MonsterRestController {

	@Autowired
	private IGeneralNameService<Monster> monsterService;

	@JsonView(Views.Basic.class)
	@GetMapping("/monsters")
	public List<Monster> findAll() {
		return monsterService.findAll();
	}

	@GetMapping("/monster/{id}")
	@JsonView(Views.Basic.class)
	public Monster findById(@PathVariable Long id) {
		return monsterService.findById(id);
	}
}
