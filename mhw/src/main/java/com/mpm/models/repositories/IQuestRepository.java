package com.mpm.models.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Quest;
import com.mpm.entities.QuestMonsters;
import com.mpm.entities.QuestType;

@Repository
public interface IQuestRepository extends CrudRepository<Quest, Long> {

	List<Quest> findByType(QuestType type);

	List<Quest> findByMonsters(Set<QuestMonsters> monsters);

}
