package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Monster;
import com.mpm.models.services.IGeneralNameService;

@RestController
public class MonsterRestController {

	@Autowired
	private IGeneralNameService<Monster> monsterService;

	@GetMapping("/monsters")
	public List<Monster> findAll() {
		return monsterService.findAll();
	}

}
