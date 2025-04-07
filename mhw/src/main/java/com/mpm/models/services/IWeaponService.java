package com.mpm.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mpm.entities.Weapon;
import com.mpm.entities.WeaponType;

@Service
public interface IWeaponService extends IGeneralService<Weapon> {

	List<Weapon> findByWeaponType(WeaponType weaponType);

}
