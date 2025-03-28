package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Monster;

@Repository
public interface IMonsterRepository extends CrudRepository<Monster, Long> {

	Monster findByName(String name);
}
