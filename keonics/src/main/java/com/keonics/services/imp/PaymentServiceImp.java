package com.keonics.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keonics.entity.Payments;
import com.keonics.modal.PaymentDao;
import com.keonics.services.PaymentService;

@Service
public class PaymentServiceImp implements PaymentService{

	private PaymentDao paymentDao;
	
	@Autowired
	public PaymentServiceImp(PaymentDao paymentDao) {
	
		this.paymentDao = paymentDao;
	
	}
	
	@Override
	@Transactional
	public List<Payments> getPayments() {
		
		return paymentDao.getPayments();
		
	}

	@Override
	@Transactional
	public Payments addPayment(Payments payment) {
		
		return paymentDao.addPayment(payment);
		
	}

	@Override
	@Transactional
	public Payments delete(int id) {

		return paymentDao.delete(id);
		
	}

	@Override
	@Transactional
	public Payments getPaymentById(int id) {
		
		return paymentDao.getPaymentById(id);
		
	}

	@Override
	@Transactional	
	public void updatePayments(Payments payment) {
		
		paymentDao.updatePayments(payment);
		
	}
}
