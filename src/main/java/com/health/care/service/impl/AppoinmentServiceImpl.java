package com.health.care.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.care.entity.Appoinment;
import com.health.care.exception.AppoinmentNotFoundException;
import com.health.care.repo.AppoinmentRepository;
import com.health.care.service.IAppoinmentService;

@Service
public class AppoinmentServiceImpl implements IAppoinmentService {

	@Autowired
	private AppoinmentRepository repo;

	public Long saveAppoinment(Appoinment appoinment) {
		return repo.save(appoinment).getId();
	}


	public void updateAppoinment(Appoinment appoinment) {
		if(appoinment.getId()!=null && repo.existsById(appoinment.getId())) {
			repo.save(appoinment);
		} else {
			throw new AppoinmentNotFoundException("Appoinment '"+appoinment.getId()+"' not exist");
		}
	}


	@Override
	public void deleteAppoinment(Long id) {
		repo.delete(getOneAppoinment(id));
	}

	@Override
	public Appoinment getOneAppoinment(Long id) {
		Optional<Appoinment> opt = repo.findById(id);
		if(opt.isEmpty()) {
			throw new AppoinmentNotFoundException("Appoinment '"+id+"' not exist");
		} else {
			return opt.get();
		}
	}

	@Override
	public List<Appoinment> getAllAppoinments() {
		return repo.findAll();
	}

}
