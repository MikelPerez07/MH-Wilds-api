package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Armor;

@Repository
public interface IArmorRepository extends CrudRepository<Armor, Long> {

}
