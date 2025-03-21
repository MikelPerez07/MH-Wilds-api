package com.mpm.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpm.entities.Location;
import com.mpm.models.repositories.ILocationRepository;

@Service
public class LocationServiceImpl implements IGeneralService<Location> {

	@Autowired
	private ILocationRepository locationRepository;

	@Override
	public List<Location> findAll() {
		return (List<Location>) locationRepository.findAll();
	}

	@Override
	public Location findById(Long id) {
		return locationRepository.findById(id).orElse(null);
	}

	@Override
	public Location save(Location t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
