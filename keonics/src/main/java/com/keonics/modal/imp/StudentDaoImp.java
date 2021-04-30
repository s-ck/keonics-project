package com.keonics.modal.imp;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keonics.entity.Center;
import com.keonics.entity.Student;
import com.keonics.modal.StudentDao;

@Repository
public class StudentDaoImp implements StudentDao{

	private EntityManager entityManager;
	
	@Autowired
	public StudentDaoImp(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
	}
	
	public List<Student> getAllStudents() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createSQLQuery("select s.id,s.firstname,s.lastname,s.email,s.mobile_num,s.gender,s.address1,s.address2,"
				+ "s.city,s.pincode,c.centername from student s,center c where s.center_id = c.id");
		
		return query.getResultList();
	}
	
	public List<Student> getAllStudents(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		List<Object[]> list = session.createSQLQuery("select * from center where user_id = "+id).getResultList();
		
		int centerid = 0;
		
		for(Object [] obj:list) {
			centerid = Integer.parseInt(obj[0].toString());
		}
		
		Center center = session.get(Center.class, centerid); 
		
		Query query = session.createSQLQuery("select s.id,s.firstname,s.lastname,s.email,s.mobile_num,s.gender,s.address1,s.address2,"
				+ "s.city,s.pincode,c.centername from student s,center c where s.center_id = c.id and c.id = "+center.getId());
		
		return query.getResultList();
	}

	public Student addStudent(Student student) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(student);
		
		return student;
	}

	public Student delete(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Student student = session.get(Student.class, id);
		
		session.delete(student);
		
		return student;
	}
}
