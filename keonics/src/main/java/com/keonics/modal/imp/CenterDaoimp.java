package com.keonics.modal.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keonics.entity.Center;
import com.keonics.entity.Users;
import com.keonics.modal.CenterDao;

@Repository
public class CenterDaoimp implements CenterDao{

	private EntityManager entityManager;
	
	@Autowired
	public CenterDaoimp(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
	}
	
	@Override
	public List<Center> getCenters() {
		Session session = entityManager.unwrap(Session.class);
		List<Center> centers = session.createQuery("from Center", Center.class).getResultList();
		return centers;
	}

	@Override
	public Center addCenter(Center center) {
		Session session = entityManager.unwrap(Session.class);
		if(center.getId() != 0) {
			
			session.update(center);
			
		}else {
			Users user = session.get(Users.class,center.getUser().getId());
			center.setUser(user);
			session.save(center);
			
		}
		return center;
	}

	@Override
	public Center delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Center center = session.get(Center.class, id);
		session.delete(center);
		return center;
	}

	@Override
	public List<Center> getCenters(int id) {
		Session session = entityManager.unwrap(Session.class);
		List<Object[] > list = session.createSQLQuery("SELECT * FROM employe.center where user_id = "+id).getResultList();
		int user_id = 0;
		for(Object [] obj : list) {
			user_id = Integer.parseInt(obj[0].toString());
		}
		Center center = session.get(Center.class, user_id);
		List<Center> listcenters = new ArrayList<Center>();
		listcenters.add(center);
		return listcenters;
	}

}
