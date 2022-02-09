package com.health.care.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.health.care.entity.Specialization;
import com.health.care.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationContoller {

	@Autowired
	private ISpecializationService service; 
	
	//1. Show Register Page
	@GetMapping("/register")
	public String showReg() {
		return "SpecializationRegister";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Specialization specialization, Model model) {
		//System.out.println(specialization.);
		Long id = service.saveSpecialization(specialization);
		String msg = "Specializaztion '"+id+"' created";
		model.addAttribute("msg", msg);
		return "SpecializationRegister";
	}

}
