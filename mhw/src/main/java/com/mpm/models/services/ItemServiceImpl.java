package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Item;
import com.mpm.models.repositories.IItemRepository;

@Service
public class ItemServiceImpl implements IGeneralService<Item> {

	@Autowired
	private IItemRepository itemRepository;

	@Override
	public List<Item> findAll() {
		return (List<Item>) itemRepository.findAll();
	}

	@Override
	public Item findById(Long id) {
		return itemRepository.findById(id).orElse(null);
	}

	@Override
	public Item save(Item t) {
		return itemRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {

		itemRepository.deleteById(id);
	}

}
