package com.mpm.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mpm.entities.Quest;
import com.mpm.entities.QuestType;

@Service
public interface IQuestService extends IGeneralService<Quest> {

	List<Quest> findAllByType(QuestType type);

}
