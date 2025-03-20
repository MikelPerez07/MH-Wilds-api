package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Weapon;

@Repository
public interface IWeaponRepository extends CrudRepository<Weapon, Long> {

}
