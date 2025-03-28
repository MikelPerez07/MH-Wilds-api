package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.WeaponType;

@Repository
public interface IWeaponTypeRepository extends CrudRepository<WeaponType, Long> {

	WeaponType findByType(String type);

}
