package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Skill;
import com.mpm.models.repositories.ISkillRepository;

@Service
public class SkillServiceImpl implements IGeneralService<Skill> {

	@Autowired
	private ISkillRepository skillRepository;

	@Override
	public List<Skill> findAll() {
		return (List<Skill>) skillRepository.findAll();
	}

	@Override
	public Skill findById(Long id) {
		return skillRepository.findById(id).orElse(null);
	}

	@Override
	public Skill save(Skill t) {
		return skillRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		skillRepository.deleteById(id);
	}

}
