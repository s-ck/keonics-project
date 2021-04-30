package com.keonics.modal.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keonics.entity.Payments;
import com.keonics.modal.PaymentDao;

@Repository
public class PaymentDaoimp implements PaymentDao{

	private EntityManager entityManager;
	
	@Autowired
	public PaymentDaoimp(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
	}
	
	@Override
	public List<Payments> getPayments() {
	
		Session session = entityManager.unwrap(Session.class);
		List<Payments> payments = session.createSQLQuery("select c.centername,p.payment,p.startdate,p.enddate from payments p, center c where c.id=p.center_id").getResultList();
		return payments;
		
	}

	@Override
	public Payments addPayment(Payments payment) {
		
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(payment);
		return payment;
		
	}

	@Override
	public Payments delete(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		Payments payment = session.get(Payments.class, id);
		session.delete(payment);
		return payment;
		
	}

	@Override
	public Payments getPaymentById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		List<Object[]> list = session.createSQLQuery("select * from payments where center_id = "+id).getResultList();
		int Payment_id = 0;
		for(Object[] obj : list) {
		
			Payment_id = Integer.parseInt(String.valueOf(Arrays.deepToString(obj).split(",")[0].charAt(1)));
			
		}
		Payments payment = session.get(Payments.class, Payment_id);
		return payment;
		
	}

	@Override
	public void updatePayments(Payments payment) {
		
		Session session = entityManager.unwrap(Session.class);
		session.merge(payment);
		
	}

}
