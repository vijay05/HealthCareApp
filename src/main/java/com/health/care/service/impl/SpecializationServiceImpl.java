package com.health.care.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.care.entity.Specialization;
import com.health.care.exception.SpecializationNotFoundException;
import com.health.care.repo.SpecializationRepository;
import com.health.care.service.ISpecializationService;
import com.health.care.util.AppUtil;



@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private SpecializationRepository repo; //HAS-A
	
	@Override
	public Long saveSpecialization(Specialization obj) {
		obj = repo.save(obj); //INSERT
		return obj.getSpecId();//PK
	}

	@Override
	public List<Specialization> getAllSpecialiation() {
		return repo.findAll();
	}

	@Override
	public void deleteSpecialization(Long id) {
		repo.delete(getOneSpecialization(id));
	}

	@Override
	public Specialization getOneSpecialization(Long id) {
		Optional<Specialization> opt = repo.findById(id);
		if (opt.isEmpty()) {
			throw new SpecializationNotFoundException("Specialiation '"+id+"' not exist");
		} else {
			return opt.get();	
		}
	}

	@Override
	public void updateSpecialization(Specialization obj) {
		if (obj.getSpecId() != null && repo.existsById(obj.getSpecId())) {
			repo.save(obj);	
		} else {
			throw new SpecializationNotFoundException("Specialiation '"+obj.getSpecId()+"' not updated");
		}
		
	}

	@Override
	public Map<Long, String> getSpecialiaztionIdAndName() {
		List<Object[]> list = repo.getSpecializationIdAndName();
		return AppUtil.convertListToMap(list);
	}
	
	
}
