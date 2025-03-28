package com.mpm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.entities.Quest;
import com.mpm.entities.QuestType;
import com.mpm.models.services.IGeneralNameService;
import com.mpm.models.services.IQuestService;

@RestController
public class QuestRestController {

	@Autowired
	private IQuestService questService;

	@Autowired
	private IGeneralNameService<QuestType> questTypeService;

	@GetMapping("/quests")
	public List<Quest> findAll() {
		return questService.findAll();
	}

	@GetMapping("/quests/{type}")
	public List<Quest> findAllByType(@PathVariable String type) {
		QuestType questType = questTypeService.findByName(type);
		return questService.findAllByType(questType);
	}

	@GetMapping("/quest/{id}")
	public Quest findById(@PathVariable Long id) {
		return questService.findById(id);
	}

}
