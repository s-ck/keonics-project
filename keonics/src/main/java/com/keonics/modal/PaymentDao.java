package com.keonics.modal;

import java.util.List;

import com.keonics.entity.Payments;

public interface PaymentDao {

	public List<Payments> getPayments();
	
	public Payments getPaymentById(int id);
	
	public Payments addPayment(Payments payment);
	
	public void updatePayments(Payments payment);
	
	public Payments delete(int id);
	
}
