package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Quest;
import com.mpm.entities.QuestType;
import com.mpm.models.repositories.IQuestRepository;

@Service
public class QuestServiceImpl implements IQuestService {

	@Autowired
	private IQuestRepository questDAO;

	@Override
	public List<Quest> findAll() {
		return (List<Quest>) questDAO.findAll();
	}

	@Override
	public List<Quest> findAllByType(QuestType type) {
		return questDAO.findByType(type);
	}

	@Override
	public Quest findById(Long id) {
		return questDAO.findById(id).orElse(null);
	}

	@Override
	public Quest save(Quest t) {
		return questDAO.save(t);
	}

	@Override
	public void deleteById(Long id) {
		questDAO.deleteById(id);
	}

}
