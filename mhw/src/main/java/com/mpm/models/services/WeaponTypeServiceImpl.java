package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.WeaponType;
import com.mpm.models.repositories.IWeaponTypeRepository;

@Service
public class WeaponTypeServiceImpl implements IGeneralNameService<WeaponType> {

	@Autowired
	private IWeaponTypeRepository weaponTypeRepository;

	@Override
	public List<WeaponType> findAll() {
		return (List<WeaponType>) weaponTypeRepository.findAll();
	}

	@Override
	public WeaponType findById(Long id) {
		return weaponTypeRepository.findById(id).orElse(null);
	}

	@Override
	public WeaponType save(WeaponType t) {
		return weaponTypeRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {

		weaponTypeRepository.deleteById(id);
	}

	@Override
	public WeaponType findByName(String name) {
		return weaponTypeRepository.findByType(name);
	}

}
