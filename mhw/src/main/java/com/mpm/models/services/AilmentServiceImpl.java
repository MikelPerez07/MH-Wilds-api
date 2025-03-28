package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Ailment;
import com.mpm.models.repositories.IAilmentRepository;

@Service
public class AilmentServiceImpl implements IGeneralNameService<Ailment> {

	@Autowired
	private IAilmentRepository ailmentRepository;

	@Override
	public List<Ailment> findAll() {
		return (List<Ailment>) ailmentRepository.findAll();
	}

	@Override
	public Ailment findById(Long id) {
		return ailmentRepository.findById(id).orElse(null);
	}

	@Override
	public Ailment save(Ailment t) {
		// not used
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// not used

	}

	@Override
	public Ailment findByName(String name) {
		// TODO Auto-generated method stub
		return ailmentRepository.findByName(name);
	}

}
