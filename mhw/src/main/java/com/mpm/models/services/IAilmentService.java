package com.mpm.models.services;

import org.springframework.stereotype.Service;

@Service
public interface IAilmentService<T> extends IGeneralService<T> {

	T findByName(String name);
}
