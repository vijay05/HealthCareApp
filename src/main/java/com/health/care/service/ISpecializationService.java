package com.health.care.service;

import java.util.List;
import java.util.Map;

import com.health.care.entity.Specialization;

public interface ISpecializationService {

	Long saveSpecialization(Specialization obj);
	List<Specialization> getAllSpecialiation();
	void deleteSpecialization(Long id);
	Specialization getOneSpecialization(Long id);
	void updateSpecialization(Specialization obj);
	Map<Long, String> getSpecialiaztionIdAndName();
	
}
