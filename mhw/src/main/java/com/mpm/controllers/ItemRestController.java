package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Item;
import com.mpm.models.services.IGeneralService;

@RestController
public class ItemRestController {

	@Autowired
	private IGeneralService<Item> itemService;

	@GetMapping("/items")
	public List<Item> findAll() {
		return itemService.findAll();
	}

	@GetMapping("/item/{id}")
	public Item findById(@PathVariable Long id) {
		return itemService.findById(id);
	}

	@PostMapping("/item")
	public Item create(@RequestBody Item item) {
		return itemService.save(item);
	}

	@DeleteMapping("/item/{id}")
	public void deleteById(@PathVariable Long id) {
		itemService.deleteById(id);
	}

}
