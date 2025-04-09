package com.mpm.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Monster;
import com.mpm.entities.QuestMonsters;

@Repository
public interface IQuestMonsterRepository extends CrudRepository<QuestMonsters, Long> {

	List<QuestMonsters> findByMonster(Monster monster);

}
