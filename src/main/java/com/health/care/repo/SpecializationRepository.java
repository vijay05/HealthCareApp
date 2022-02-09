package com.health.care.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.health.care.entity.Specialization;

@Component
public interface SpecializationRepository 
extends JpaRepository<Specialization, Long> {

}
