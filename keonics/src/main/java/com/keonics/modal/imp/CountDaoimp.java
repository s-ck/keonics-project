package com.keonics.modal.imp;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keonics.entity.Batch;
import com.keonics.entity.Center;
import com.keonics.entity.Certification;
import com.keonics.entity.Enquiry;
import com.keonics.entity.Payments;
import com.keonics.entity.Student;
import com.keonics.modal.Count;

@Repository
public class CountDaoimp implements Count{

	private EntityManager entityManager;
	
	@Autowired
	public CountDaoimp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public int getCenterCount() {
		Session session = entityManager.unwrap(Session.class);
		return session.createSQLQuery("select * from center").getResultList().size();
	}

	@Override
	public int getEnquiryCount() {
		Session session = entityManager.unwrap(Session.class);
		return session.createSQLQuery("select * from enquiry").getResultList().size();
	}

	@Override
	public int getBatchCount() {
		Session session = entityManager.unwrap(Session.class);
		return session.createSQLQuery("select * from batch").getResultList().size();
	}

	@Override
	public int getPaymentsCount() {
		Session session = entityManager.unwrap(Session.class);
		return session.createSQLQuery("select * from payments").getResultList().size();
	}

	@Override
	public int getStudentCount() {
		Session session = entityManager.unwrap(Session.class);
		return session.createSQLQuery("select * from student").getResultList().size();
	}

	@Override
	public int getCertificationCount() {
		Session session = entityManager.unwrap(Session.class);
		return session.createSQLQuery("select * from certification").getResultList().size();	
	}
}
