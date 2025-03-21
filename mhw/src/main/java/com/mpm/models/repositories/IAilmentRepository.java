package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Ailment;

@Repository
public interface IAilmentRepository extends CrudRepository<Ailment, Long> {

	Ailment findByName(String name);
}
