package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Location;

@Repository
public interface ILocationRepository extends CrudRepository<Location, Long> {

}
