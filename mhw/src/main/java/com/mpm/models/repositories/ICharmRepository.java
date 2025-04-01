package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Charm;

@Repository
public interface ICharmRepository extends CrudRepository<Charm, Long> {

}
