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

import com.keonics.entity.Batch;
import com.keonics.services.BatchService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BatchController {

	private BatchService batchService;
	
	@Autowired
	public BatchController(BatchService bacthService) {
	
		this.batchService = bacthService;
		
	}
	
	@GetMapping("/getBatchs")
	public List<Batch> getBatchs(){
		
		return batchService.getBatchs();
		
	}
	
	@GetMapping("/getBatchs/{id}")
	public List<Batch> getBatchs(@PathVariable int id){
		
		return batchService.getBatchs(id);
		
	}
	
	@PostMapping("/addBatch")
	public Batch addBatch(@RequestBody Batch batch) {
		
		return batchService.addBatch(batch);
		
	}
	
	@DeleteMapping("/deleteBatch/{id}")
	public Batch delete(@PathVariable int id) {
		
		return batchService.deleteBatch(id);
		
	}
}
