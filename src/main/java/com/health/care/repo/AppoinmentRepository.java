package com.health.care.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.care.entity.Appoinment;

public interface AppoinmentRepository extends JpaRepository<Appoinment, Long> {

}
