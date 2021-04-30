package com.keonics.modal.imp;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keonics.entity.Roles;
import com.keonics.entity.Users;
import com.keonics.modal.UsersDao;

@Repository
public class UserDaoimp implements UsersDao{

	private EntityManager entitymanager;
	
	@Autowired
	public UserDaoimp(EntityManager entityManager) {
		this.entitymanager = entityManager;
	}
	
	@Override
	public Users getUserByemail(String email) {
		
		Session session = entitymanager.unwrap(Session.class);
		List<Object[]> users = session.createSQLQuery("select * from users where email_id = "+"'"+email+"'").list();
		int id = 0;
		for(Object [] user : users) {
			
			id = Integer.parseInt(user[0].toString());
		}
		return session.get(Users.class, id);
		
	}

	@Override
	public Users saveUser(Users user, int roleId) {
		
		Users userData = null;
		if(user != null) {
			Session session = entitymanager.unwrap(Session.class);
			List<Users> list = session.createSQLQuery("select email_id from users where email_id = "+"'"+user.getEmail()+"'").list();
			if(list.size() == 0) {
				Roles role =  session.get(Roles.class, roleId);
				user.setRoles(role);
				session.saveOrUpdate(user);
				userData = user;
			}
		}
		return userData;
	}

	public Users deleteUser(int id) {
		
		Session session = entitymanager.unwrap(Session.class);
		Users user = session.get(Users.class, id);
		session.delete(user);
		return user;
	}

	@Override
	public List<Users> getAllUsers() {
		Session session = entitymanager.unwrap(Session.class);
		List<Users> list = session.createQuery("from Users", Users.class).getResultList();
		return list;
	}

	@Override
	public List<Users> getUserByCenter() {
		
		Session session = entitymanager.unwrap(Session.class);
		String sql = "select user.id,user.email_id,user.status from users user,role roles where user.roles_id = roles.id"
				+" and roles.roles = 'center'"+ " and user.status ="+"'"+"active"+"'";
		Query query = session.createSQLQuery(sql);
		List<Users> list = query.getResultList();
		return list;
	}

}
