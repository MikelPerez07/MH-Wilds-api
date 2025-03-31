package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Skill;

@Repository
public interface ISkillRepository extends CrudRepository<Skill, Long> {

}
