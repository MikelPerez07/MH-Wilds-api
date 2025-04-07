package com.mpm.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Weapon;
import com.mpm.entities.WeaponType;

@Repository
public interface IWeaponRepository extends CrudRepository<Weapon, Long> {

	List<Weapon> findByType(WeaponType weaponType); // search by type

}
