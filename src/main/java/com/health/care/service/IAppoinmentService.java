package com.health.care.service;

import java.util.List;

import com.health.care.entity.Appoinment;

public interface IAppoinmentService {
	Long saveAppoinment(Appoinment appoinment);
	void updateAppoinment(Appoinment appoinment);
	void deleteAppoinment(Long id);
	Appoinment getOneAppoinment(Long id);
	List<Appoinment> getAllAppoinments();

}
