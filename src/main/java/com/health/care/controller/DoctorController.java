package com.health.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.health.care.entity.Doctor;
import com.health.care.service.IDoctorService;
import com.health.care.service.ISpecializationService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private IDoctorService service;
	@Autowired
	private ISpecializationService specializationService;
	
	private void commonUi(Model model) {
		model.addAttribute("specializations", specializationService.getSpecialiaztionIdAndName());
	}
	
	//1. show Register page
	@GetMapping("/register")
	public String showReg(Model model) {
		commonUi(model);
		return "DoctorRegister";
	}
	
	//2. Save Form data
	@PostMapping("/save")
	public String save(@ModelAttribute Doctor doctor, Model model) {
		Long id =  service.saveDoctor(doctor);
		String message = "Doctor '"+id+"' created";
		model.addAttribute("message", message);
		commonUi(model);
		return "DoctorRegister";
	}
	
	//3. show data Page
	@GetMapping("/all")
	public String showAll(Model model) {
		List<Doctor> list = service.getAllDoctors();
		model.addAttribute("list", list);
		return "DoctorData";
	}
	
	//4. Delete by id
	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		service.deleteDoctor(id);
		return "redirect:all";
	}
	
	//5. show data in edit page
	@GetMapping("/edit")
	public String showEdit(@RequestParam Long id, Model model) {
		Doctor doc =  service.getOneDoctor(id);
		model.addAttribute("doctor", doc);
		commonUi(model);
		return "DoctorEdit";
	}
	
	//6. update on submit
	@PostMapping("/update")
	public String update(@ModelAttribute Doctor doctor) {
		service.updateDoctor(doctor);
		return "redirect:all";
	}
} 
