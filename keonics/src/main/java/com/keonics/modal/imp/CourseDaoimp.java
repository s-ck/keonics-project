package com.keonics.modal.imp;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keonics.entity.Course;
import com.keonics.modal.CourseDao;

@Repository
public class CourseDaoimp implements CourseDao{

	private EntityManager entityManager;
	
	@Autowired
	public CourseDaoimp(EntityManager entityManager) {
	
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Course> getAllcourse() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Course> query = session.createSQLQuery("select id, course from course");
		
		return query.getResultList();
	}

	@Override
	public Course getCourseById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Course.class, id);
		
	}

	@Override
	public Course save(Course course) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(course);
		
		return course;
	}

	@Override
	public Course delete(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Course course = session.get(Course.class, id);
		
		session.delete(course);
		
		return course;
	}

}
