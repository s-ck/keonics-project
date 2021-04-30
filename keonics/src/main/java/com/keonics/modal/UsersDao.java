package com.keonics.modal;

import java.util.List;

import com.keonics.entity.Users;

public interface UsersDao {

	public Users getUserByemail(String email);
	
	public List<Users> getAllUsers();
	
	public List<Users> getUserByCenter();
	
	public Users saveUser(Users user, int roleId);
	
	public Users deleteUser(int id);
}
