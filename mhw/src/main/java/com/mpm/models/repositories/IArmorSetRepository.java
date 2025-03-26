package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.ArmorSet;

@Repository
public interface IArmorSetRepository extends CrudRepository<ArmorSet, Long> {

}
