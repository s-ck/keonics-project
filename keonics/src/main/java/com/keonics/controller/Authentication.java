package com.keonics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keonics.entity.Users;
import com.keonics.jwt.utils.JwtUtil;
import com.keonics.modal.JwtRequest;
import com.keonics.modal.JwtResponse;
import com.keonics.services.CustomUserDetailsService;
import com.keonics.services.imp.UserServiceImp;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000"})
public class Authentication {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserServiceImp userServicesimp;
	
	@PostMapping("/token")
	public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest) throws BadCredentialsException{
		
		UserDetails userDetails = null;
		
		try {
			
			Users user = userServicesimp.getUserByemail(jwtRequest.getUserName());
			if(user != null && (user.getEmail().equals(jwtRequest.getUserName()) && user.getPassword().equals(jwtRequest.getPassword()))) {
				
				userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUserName());
			}
			//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
			
		}catch (Exception e) {
			
			throw new BadCredentialsException("User not found");
		}
		return ResponseEntity.ok(new JwtResponse(jwtUtil.generateToken(userDetails)));
	}
}
