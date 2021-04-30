package com.keonics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keonics.entity.Certification;
import com.keonics.services.CertificationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CertificationController {

	private CertificationService certificationService;
	
	@Autowired
	public CertificationController(CertificationService certificationService) {
	
		this.certificationService = certificationService;
		
	}
	
	@GetMapping("/certifications")
	public List<Certification> getCertifications(){
		
		return certificationService.getCertifications();
		
	}
	
	@GetMapping("/certifications/{id}")
	public List<Certification> getCertifications(@PathVariable int id){
		
		return certificationService.getCertifications(id);
		
	}
	
	@PostMapping("/addCerification")
	public Certification addCertification(@RequestBody Certification certification) {
		
		return certificationService.addCertification(certification);
		
	}
	
	@DeleteMapping("/deletecertification/{id}")
	public Certification deleteCertification(int id) {
		
		return certificationService.deleteCertification(id);
		
	}
}
