package com.health.care.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.health.care.entity.Specialization;
import com.health.care.repo.SpecializationRepository;
import com.health.care.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private SpecializationRepository repo;

	@Transactional
	public Long saveSpecialization(Specialization obj) {
		obj = repo.save(obj);
		Long i = obj.
		return (long) 1;
	}
}
