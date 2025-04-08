package com.mpm.models.services;

import java.util.List;

import com.mpm.entities.MonsterIcon;
import com.mpm.models.repositories.IMonsterIconRepository;

public class MonsterIconServiceImpl implements IGeneralService<MonsterIcon> {

	private IMonsterIconRepository iconRepository;

	@Override
	public List<MonsterIcon> findAll() {
		// TODO Auto-generated method stub
		return (List<MonsterIcon>) iconRepository.findAll();
	}

	@Override
	public MonsterIcon findById(Long id) {
		// TODO Auto-generated method stub
		return iconRepository.findById(id).orElse(null);
	}

	@Override
	public MonsterIcon save(MonsterIcon t) {
		// TODO Auto-generated method stub
		return iconRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		iconRepository.deleteById(id);
	}

}
