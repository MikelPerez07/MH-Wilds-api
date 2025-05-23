package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mpm.entities.Monster;
import com.mpm.entities.Quest;
import com.mpm.entities.QuestMonsters;
import com.mpm.entities.QuestType;
import com.mpm.entities.Views.Views;
import com.mpm.models.services.IGeneralNameService;
import com.mpm.models.services.IGeneralService;
import com.mpm.models.services.IQuestMonsterService;
import com.mpm.models.services.IQuestService;

@CrossOrigin(origins = ("http://localhost:4201"))
@RestController
public class QuestRestController {

	@Autowired
	private IQuestService questService;

	@Autowired
	private IGeneralNameService<QuestType> questTypeService;

	@Autowired
	private IQuestMonsterService questMonsterService;

	@Autowired
	private IGeneralService<Monster> monsterService;

	@JsonView(Views.Basic.class)
	@GetMapping("/quests")
	public List<Quest> findAll() {
		return questService.findAll();
	}

	@JsonView(Views.Basic.class)
	@GetMapping("/quests/{type}")
	public List<Quest> findAllByType(@PathVariable String type) {
		QuestType questType = questTypeService.findByName(type);
		return questService.findAllByType(questType);
	}

	@JsonView(Views.Basic.class)
	@GetMapping("/quest/{id}")
	public Quest findById(@PathVariable Long id) {
		return questService.findById(id);
	}

	@JsonView(Views.Quest.class)
	@GetMapping("/quests/monster/{id}")
	public List<QuestMonsters> findByMonsterId(@PathVariable Long id) {

		Monster monster = monsterService.findById(id);
		return questMonsterService.findAllByMonster(monster);
	}

	// TODO get the quest related to a monster

}
