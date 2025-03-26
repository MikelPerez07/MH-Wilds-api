package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.ArmorSet;
import com.mpm.models.repositories.IArmorSetRepository;

@Service
public class ArmorSetServiceImpl implements IGeneralService<ArmorSet> {

	@Autowired
	private IArmorSetRepository setRepository;

	@Override
	public List<ArmorSet> findAll() {
		return (List<ArmorSet>) setRepository.findAll();
	}

	@Override
	public ArmorSet findById(Long id) {
		return setRepository.findById(id).orElse(null);
	}

	@Override
	public ArmorSet save(ArmorSet t) {
		return setRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		setRepository.deleteById(id);
	}

}
