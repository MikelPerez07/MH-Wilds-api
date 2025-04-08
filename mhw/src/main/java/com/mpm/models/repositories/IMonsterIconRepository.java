package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.MonsterIcon;

@Repository
public interface IMonsterIconRepository extends CrudRepository<MonsterIcon, Long> {

}
