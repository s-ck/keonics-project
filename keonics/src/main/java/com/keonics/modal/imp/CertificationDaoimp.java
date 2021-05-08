package com.keonics.modal.imp;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keonics.entity.Certification;
import com.keonics.entity.Payments;
import com.keonics.modal.CertificationDao;
import com.keonics.services.PaymentService;

@Repository
public class CertificationDaoimp implements CertificationDao{

	private EntityManager entityManager;
	
	private PaymentService paymentservice;
	
	@Autowired
	public CertificationDaoimp(EntityManager entityManager, PaymentService paymentService) {
	
		this.entityManager = entityManager;
		this.paymentservice = paymentService;
		
	}
	
	@Override
	public List<Certification> getCertifications() {
		
		Session session = entityManager.unwrap(Session.class);
		List<Certification> certification = session.createSQLQuery("select c.id,s.id as studentid,cou.id as courseid,cent.id as centerid,s.firstname,cou.course,c.status,cent.centername from certification c,center cent,course cou,student s where c.course_id = cou.id and c.student_id = s.id and c.center_id = cent.id").getResultList();
		return certification;	
	}
	
	@Override
	public List<Certification> getCertifications(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		List<Certification> certification = session.createSQLQuery("select c.id,s.firstname,cou.course,c.status,cent.centername from certification c,center cent,course cou,student s where \r\n"
				+ "c.course_id = cou.id and c.student_id = s.id and c.center_id = cent.id and c.center_id = "+id).getResultList();
		return certification;	
	}

	@Override
	public Certification addCertification(Certification certification) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Certification obj = session.get(Certification.class, certification.getId());
		
		if(obj != null && obj.getId() != 0) {
		
			Payments payment = paymentservice.getPaymentById(certification.getCenter().getId());
			
			double certification_payment = payment.getPayment() - 3000;
			
			payment.setPayment(certification_payment);
			
			paymentservice.updatePayments(payment);
			
			obj.setStatus("approved");
			
			session.saveOrUpdate(obj);
		}
		else {
		
			session.saveOrUpdate(certification);
		}
		
		return certification;
		
	}

	@Override
	public Certification deleteCertification(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Certification certification = session.get(Certification.class, id);
		
		session.delete(certification);
		
		return certification;
		
	}

}
