package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.QuestType;

@Repository
public interface IQuestTypeRepository extends CrudRepository<QuestType, Long> {

	QuestType findByType(String type);
}
