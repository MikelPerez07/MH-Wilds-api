package com.mpm.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IGeneralService<T> {

	List<T> findAll();

	T findById(Long id);

	T save(T t);

	void deleteById(Long id);

}
