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

import com.keonics.entity.Enquiry;
import com.keonics.services.EnquiryServices;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class EnquiryController {

	private EnquiryServices enquiryService;
	
	@Autowired
	public EnquiryController(EnquiryServices enquiryService) {
		this.enquiryService = enquiryService;
	}
	
	@GetMapping("/enquiryList")
	public List<Enquiry> getAllenquiries(){
		
		return enquiryService.getAllenquiry();
		
	}
	
	@GetMapping("/center/enquiryList/{id}")
	public List<Enquiry> getAllenquiries(@PathVariable int id){
		
		return enquiryService.getAllenquiry(id);
		
	}
	
	@PostMapping("/addEnquiry")
	public Enquiry addEnquiry(@RequestBody Enquiry enquiry) throws Exception{
		
		return enquiryService.save(enquiry, enquiry.getCourse());
		
	}
	
	@GetMapping("/getEnquiry/{id}")
	public Enquiry getEnquiryById(@PathVariable int id) {
		
		return enquiryService.getEnquirybyId(id);
		
	}
	
	@DeleteMapping("/deleteEnquiry/{id}")
	public Enquiry delete(@PathVariable int id) {
		
		return enquiryService.delete(id);
		
	}
}
