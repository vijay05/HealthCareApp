package com.health.care.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.care.entity.Doctor;
import com.health.care.repo.DoctorRepository;
import com.health.care.service.IDoctorService;
import com.health.care.util.AppUtil;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository repo;
	
	public Long saveDoctor(Doctor doc) {
		return repo.save(doc).getDocId();
	}

	public List<Doctor> getAllDoctors() {
		return repo.findAll();
	}

	public Doctor getOneDoctor(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteDoctor(Long id) {
		repo.deleteById(id);
	}

	@Override
	public void updateDoctor(Doctor doc) {
		repo.save(doc);
	}

	@Override
	public Map<Long, String> getDocIdAndNames() {
		List<Object[]> list = repo.getDocIdAndNames();
		return AppUtil.convertListToMap(list);
	}

}

