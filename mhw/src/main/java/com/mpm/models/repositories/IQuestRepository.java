package com.mpm.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Quest;
import com.mpm.entities.QuestType;

@Repository
public interface IQuestRepository extends CrudRepository<Quest, Long> {

	List<Quest> findByType(QuestType type);

}
