package com.health.care.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.health.care.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query("SELECT doc.docId, doc.docName FROM Doctor doc")
	List<Object[]> getDocIdAndNames();

}
