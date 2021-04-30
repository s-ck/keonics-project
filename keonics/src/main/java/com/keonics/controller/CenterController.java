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

import com.keonics.entity.Center;
import com.keonics.services.CenterService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CenterController {

	private CenterService centerService;
	
	@Autowired
	public CenterController(CenterService centerService) {
		
		this.centerService = centerService;
			
	}
	
	@GetMapping("/centers")
	public List<Center> getCenters(){
		
		return centerService.getCenters();
		
	}
	
	@GetMapping("/centers/{id}")
	public List<Center> getCenters(@PathVariable int id){
		
		return centerService.getCenters(id);
		
	}
	
	@PostMapping("/addCenter")
	public Center addCenter(@RequestBody Center center) {
		
		return centerService.addCenter(center);
		
	}
	
	@DeleteMapping("/deleteCenter/{id}")
	public Center delete(@PathVariable int id) {
		
		return centerService.delete(id);
		
	}
}
