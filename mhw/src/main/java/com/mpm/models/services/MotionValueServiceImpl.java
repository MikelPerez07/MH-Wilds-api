package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.MotionValue;
import com.mpm.entities.WeaponType;
import com.mpm.models.repositories.IMotionValuesRepository;

@Service
public class MotionValueServiceImpl implements IMotionValueService<MotionValue> {

	@Autowired
	private IMotionValuesRepository motionValuesRepository;

	@Override
	public List<MotionValue> findAll() {
		return (List<MotionValue>) motionValuesRepository.findAll();

	}

	@Override
	public MotionValue findById(Long id) {

		return motionValuesRepository.findById(id).orElse(null);
	}

	@Override
	public MotionValue findByName(String name) {
		return motionValuesRepository.findByName(name);
	}

	@Override
	public List<MotionValue> findByWeaponType(WeaponType weaponType) {
		return motionValuesRepository.findByWeaponType(weaponType);
	}

	@Override
	public MotionValue save(MotionValue t) {

		return motionValuesRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		motionValuesRepository.deleteById(id);

	}

}
