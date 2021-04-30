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

import com.keonics.entity.Payments;
import com.keonics.services.PaymentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {

	private PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		
		this.paymentService = paymentService;
		
	}
	
	@GetMapping("/payments")
	public List<Payments> getPayments(){
		
		return paymentService.getPayments();
		
	}
	
	@PostMapping("/addPayments")
	public Payments addPayments(@RequestBody Payments payment) {
		
		return paymentService.addPayment(payment);
		
	}
	
	@DeleteMapping("/deletePayment/{id}")
	public Payments deletePayment(@PathVariable int id) {
		
		return paymentService.delete(id);
		
	}
}
