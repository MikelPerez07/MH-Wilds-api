package com.mpm.models.services;

import java.util.List;

import com.mpm.entities.WeaponType;

public interface IMotionValueService<T> extends IGeneralService<T> {

	List<T> findByWeaponType(WeaponType weaponType);

	T findByName(String name);
}
