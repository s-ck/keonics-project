package com.keonics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keonics.entity.Roles;
import com.keonics.entity.Users;
import com.keonics.services.imp.UserServiceImp;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	private UserServiceImp userServiceimp;
	
	@Autowired
	public UserController(UserServiceImp userService) {
		
		this.userServiceimp = userService;
	}
	
	@PostMapping("/register")
	public Users registerUser(@RequestBody Users user) {
		
		Roles role = user.getRoles();
		return userServiceimp.saveUser(user, role.getId());
		
	}
	
	@PostMapping("/getUser")
	public Users getUserByEmail(@RequestBody Users user) {
		
		return userServiceimp.getUserByemail(user.getEmail());
	}
	
	@GetMapping("/getAllusers")
	public List<Users> getAllusers(){
		return userServiceimp.getAllUsers();
	}
	
	@GetMapping("/getCenteruser")
	public List<Users> getUserByCenter(){
		return userServiceimp.getUserByCenter();
	}
}
