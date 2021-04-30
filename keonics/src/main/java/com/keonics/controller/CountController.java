package com.keonics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keonics.services.CountService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CountController {
	
	private CountService countSerivce;
	
	@Autowired
	public CountController(CountService countService) {
		this.countSerivce = countService;
	}
	
	@GetMapping("/getCentercount")
	public int getCenterCount() {
		return countSerivce.getCenterCount();
	}
	
	@GetMapping("/getEnquirycount")
	public int getEnquiryCount() {
		return countSerivce.getEnquiryCount();
	}
	
	@GetMapping("/getBatchcount")
	public int getBatchCount() {
		return countSerivce.getBatchCount();
	}
	
	@GetMapping("/getPaymentscount")
	public int getPaymentsCount() {
		return countSerivce.getPaymentsCount();
	}
	
	@GetMapping("/getStudentscount")
	public int getStudentsCount() {
		return countSerivce.getStudentCount();
	}
	
	@GetMapping("/getCertificationcount")
	public int getCertificationCount() {
		return countSerivce.getCertificationCount();
	}
}
