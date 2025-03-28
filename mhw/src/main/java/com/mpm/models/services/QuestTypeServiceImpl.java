package com.mpm.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mpm.entities.QuestType;
import com.mpm.models.repositories.IQuestTypeRepository;

@Service
public class QuestTypeServiceImpl implements IGeneralNameService<QuestType> {

	private IQuestTypeRepository questTypeRepository;

	@Override
	public List<QuestType> findAll() {
		return (List<QuestType>) questTypeRepository.findAll();
	}

	@Override
	public QuestType findById(Long id) {
		return questTypeRepository.findById(id).orElse(null);
	}

	@Override
	public QuestType save(QuestType t) {
		return questTypeRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		questTypeRepository.deleteById(id);
	}

	@Override
	public QuestType findByName(String name) {
		return questTypeRepository.findByType(name);
	}

}
