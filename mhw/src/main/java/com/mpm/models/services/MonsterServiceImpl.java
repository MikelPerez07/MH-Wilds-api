package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Monster;
import com.mpm.models.repositories.IMonsterRepository;

@Service
public class MonsterServiceImpl implements IGeneralNameService<Monster> {

	@Autowired
	private IMonsterRepository monsterRepository;

	@Override
	public List<Monster> findAll() {
		return (List<Monster>) monsterRepository.findAll();
	}

	@Override
	public Monster findById(Long id) {
		return monsterRepository.findById(id).orElse(null);
	}

	@Override
	public Monster save(Monster t) {
		return monsterRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		monsterRepository.deleteById(id);
	}

	@Override
	public Monster findByName(String name) {
		return monsterRepository.findByName(name);
	}

}
