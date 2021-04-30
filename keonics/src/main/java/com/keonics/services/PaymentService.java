package com.keonics.services;

import java.util.List;

import com.keonics.entity.Payments;

public interface PaymentService {

	public List<Payments> getPayments();
	
	public Payments getPaymentById(int id);
	
	public Payments addPayment(Payments payment);
	
	public void updatePayments(Payments payment);
	
	public Payments delete(int id);
	
}
