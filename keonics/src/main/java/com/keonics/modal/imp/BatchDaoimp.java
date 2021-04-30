package com.keonics.modal.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keonics.entity.Batch;
import com.keonics.entity.Center;
import com.keonics.entity.Student;
import com.keonics.modal.BatchDao;

@Repository
public class BatchDaoimp implements BatchDao{

	private EntityManager entityManager;
	
	@Autowired
	public BatchDaoimp(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
	}
	
	@Override
	public List<Batch> getBatchs() {
		
		Session session = entityManager.unwrap(Session.class);
		String sql = "select b.batch_name,b.start_date,b.end_date,c.course,s.firstname,centername from batch b,student s,course c,center cent,batch_students bs where b.center_id = cent.id"
				+ " and b.center_id = c.id and b.id = bs.batch_id and s.id = bs.students_id";
		List<Batch> list = session.createSQLQuery(sql).getResultList();
		return list;
		
	}
	
	@Override
	public List<Batch> getBatchs(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		List<Object []> list = session.createSQLQuery("select * from center where user_id = "+id).getResultList();
		int centerid = 0;
		for(Object[] obj:list) {
			centerid = Integer.parseInt(obj[0].toString());
		}
		Center center = session.get(Center.class, centerid);
		String sql = "select b.batch_name,b.start_date,b.end_date,c.course,s.firstname,centername from batch b,student s,course c,center cent,batch_students bs where b.center_id = cent.id"
				+" and b.center_id = c.id and b.id = bs.batch_id and s.id = bs.students_id";
		System.out.println(sql);
				
		List<Batch> list1 = session.createQuery(sql).getResultList();		
		return list1;
	}

	@Override
	public Batch addBatch(Batch batch) {
		
		Session session = entityManager.unwrap(Session.class);
		List<Student> students = batch.getStudents();
		List<Student> studentlist = new ArrayList<Student>();
		for(Student studentid:students) {
			Student student = session.get(Student.class, studentid.getId());
			studentlist.add(student);
		}
		batch.setStudents(studentlist);
		session.saveOrUpdate(batch);
		return batch;
		
	}

	@Override
	public Batch deleteBatch(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		Batch batch = session.get(Batch.class, id);
		session.delete(batch);		
		return batch;
		
	}

}
