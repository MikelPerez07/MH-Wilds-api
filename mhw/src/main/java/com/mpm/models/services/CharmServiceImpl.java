package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Charm;
import com.mpm.models.repositories.ICharmRepository;

@Service
public class CharmServiceImpl implements IGeneralService<Charm> {

	@Autowired
	private ICharmRepository charmRepository;

	@Override
	public List<Charm> findAll() {
		return (List<Charm>) charmRepository.findAll();
	}

	@Override
	public Charm findById(Long id) {
		return charmRepository.findById(id).orElse(null);
	}

	@Override
	public Charm save(Charm t) {
		return charmRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		charmRepository.deleteById(id);
	}

}
