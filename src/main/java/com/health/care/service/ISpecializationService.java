package com.health.care.service;

import org.springframework.stereotype.Component;

import com.health.care.entity.Specialization;

@Component
public interface ISpecializationService {

	Long saveSpecialization(Specialization obj);
}
