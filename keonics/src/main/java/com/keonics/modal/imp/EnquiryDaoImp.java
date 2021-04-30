package com.keonics.modal.imp;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.keonics.modal.EnquiryDao;
import com.keonics.entity.Center;
import com.keonics.entity.Course;
import com.keonics.entity.Enquiry;


@Repository
public class EnquiryDaoImp implements EnquiryDao{

	@Autowired
	private EntityManager entityManager;
	
	public EnquiryDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Enquiry> getAllenquiry() {
		Session session = entityManager.unwrap(Session.class);
		String sql = "select e.id,e.firstname,e.email,e.mobile,course.course,c.centername from enquiry e, center c, course course, enquiry_course ec where e.id = ec.enquiry_id"
				+ " and course.id = ec.course_id and c.id = e.center_id";
		Query<Enquiry> query = session.createSQLQuery(sql);
		return query.getResultList();
	}
	
	@Override
	public List<Enquiry> getAllenquiry(@RequestBody int id) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "select e.id,e.firstname,e.email,e.mobile,course.course,c.centername from enquiry e, center c, course course, enquiry_course ec where e.id = ec.enquiry_id"
				+ " and course.id = ec.course_id and c.id = e.center_id and c.user_id = "+id;
		Query<Enquiry> query = session.createSQLQuery(sql);
		return query.getResultList();
	}

	@Override
	public Enquiry getEnquirybyId(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Enquiry.class, id);
		
	}

	@Override
	public Enquiry save(Enquiry enquiry, List<Course> courses) throws Exception {
		Session session = entityManager.unwrap(Session.class);
		enquiry.setCourse(courses);
		List<Object[]> centers = session.createSQLQuery("select * from center where user_id = "+enquiry.getCenter().getId()).getResultList();
		int centerid = 0;
		for(Object[] center : centers) {
			centerid = Integer.parseInt(center[0].toString());
		}
		Center center = session.get(Center.class, centerid);
		if(center.getStatus().equals("approved")) {
			enquiry.setCenter(center);
			session.save(enquiry);
		}
		else {
			enquiry = null;
		}
		return enquiry;
	}

	@Override
	public Enquiry delete(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Enquiry enquiry = session.get(Enquiry.class, id);
		
		session.delete(enquiry);
		
		return enquiry;
	}
	
	
}
