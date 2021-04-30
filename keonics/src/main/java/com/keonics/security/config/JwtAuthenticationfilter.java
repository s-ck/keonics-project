package com.keonics.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.keonics.jwt.utils.JwtUtil;
import com.keonics.services.CustomUserDetailsService;
import com.sun.net.httpserver.Filter.Chain;

@Component
public class JwtAuthenticationfilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil JwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		
		String token = request.getHeader("Authorization");
		
		String username = null;;
		
		String jwtToken = null;
		
		if(token != null && token.startsWith("Bearer ")) {
			
			jwtToken = token.substring(7);
			
			try {
				
				username =  JwtUtil.extractUsername(jwtToken);
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			
			UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
			
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
		}
		filterChain.doFilter(request, response);
	}
}
