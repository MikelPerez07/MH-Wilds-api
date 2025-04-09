package com.mpm.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mpm.entities.Monster;
import com.mpm.entities.QuestMonsters;

@Service
public interface IQuestMonsterService {

	List<QuestMonsters> findAllByMonster(Monster monster);

}
