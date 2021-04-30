package com.keonics.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.keonics.entity.Users;
import com.keonics.services.imp.UserServiceImp;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserServiceImp userServiceimp;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		if(email != null) {
			Users user = userServiceimp.getUserByemail(email);
			return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found");
		}
	}

}
