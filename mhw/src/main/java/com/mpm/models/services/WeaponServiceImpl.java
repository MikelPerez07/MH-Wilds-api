package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Weapon;
import com.mpm.entities.WeaponType;
import com.mpm.models.repositories.IWeaponRepository;

@Service
public class WeaponServiceImpl implements IWeaponService {

	@Autowired
	private IWeaponRepository weaponRepository;

	@Override
	public List<Weapon> findAll() {
		return (List<Weapon>) weaponRepository.findAll();
	}

	@Override
	public Weapon findById(Long id) {
		return weaponRepository.findById(id).orElse(null);
	}

	@Override
	public Weapon save(Weapon t) {
		return weaponRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		weaponRepository.deleteById(id);
	}

	@Override
	public List<Weapon> findByWeaponType(WeaponType weaponType) {
		return weaponRepository.findByType(weaponType);
	}

}
