package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Monster;
import com.mpm.entities.QuestMonsters;
import com.mpm.models.repositories.IQuestMonsterRepository;

@Service
public class QuestMonsterServiceImpl implements IQuestMonsterService {

	@Autowired
	private IQuestMonsterRepository questMonsterRepository;

	@Override
	public List<QuestMonsters> findAllByMonster(Monster monster) {
		return questMonsterRepository.findByMonster(monster);
	}

}
