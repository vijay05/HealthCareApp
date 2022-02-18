package com.health.care.service;

import java.util.List;
import java.util.Map;

import com.health.care.entity.Doctor;

public interface IDoctorService {
	Long saveDoctor(Doctor doc);
	List<Doctor> getAllDoctors();
	Doctor getOneDoctor(Long id);
	void deleteDoctor(Long id);
	void updateDoctor(Doctor doc);
	
	Map<Long,String> getDocIdAndNames();

}
