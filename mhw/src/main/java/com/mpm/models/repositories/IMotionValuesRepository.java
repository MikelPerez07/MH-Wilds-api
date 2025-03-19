package com.mpm.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.MotionValue;
import com.mpm.entities.WeaponType;

@Repository
public interface IMotionValuesRepository extends CrudRepository<MotionValue, Long> {

	// Hibernate will take care of perfoming the querys to the BBDD
	List<MotionValue> findByWeaponType(WeaponType weaponType); // search by type

	MotionValue findByName(String motionName); // search by motion name

}
