package com.health.care.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.health.care.entity.Specialization;


public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

	@Query("SELECT specId, specName FROM Specialization ")
	List<Object[]> getSpecializationIdAndName();
}
