package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Armor;
import com.mpm.models.repositories.IArmorRepository;

@Service
public class ArmorServiceImpl implements IGeneralService<Armor> {

	@Autowired
	private IArmorRepository armorDAO;

	@Override
	public List<Armor> findAll() {
		return (List<Armor>) armorDAO.findAll();
	}

	@Override
	public Armor findById(Long id) {
		return armorDAO.findById(id).orElse(null);
	}

	@Override
	public Armor save(Armor t) {
		return armorDAO.save(t);
	}

	@Override
	public void deleteById(Long id) {
		armorDAO.deleteById(id);
	}

}
