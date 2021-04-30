package com.keonics.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keonics.entity.Users;
import com.keonics.modal.imp.UserDaoimp;
import com.keonics.services.UsersSerivce;

@Service
public class UserServiceImp implements UsersSerivce{

	private UserDaoimp usersDao;
	
	@Autowired
	public UserServiceImp(UserDaoimp userDaoimp) {
		this.usersDao = userDaoimp;
	}
	
	@Override
	@Transactional
	public Users getUserByemail(String email) {
		return usersDao.getUserByemail(email);
	}

	@Override
	@Transactional
	public Users saveUser(Users user, int roleId) {

		return usersDao.saveUser(user, roleId);
	}

	@Override
	@Transactional
	public Users deleteUser(int id) {
		
		return usersDao.deleteUser(id);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersDao.getAllUsers();
	}

	@Override
	public List<Users> getUserByCenter() {		
		return usersDao.getUserByCenter();
	}

	

}
