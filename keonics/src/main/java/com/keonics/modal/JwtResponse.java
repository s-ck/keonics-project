package com.keonics.modal;

public class JwtResponse {

	private String token;
	
	public JwtResponse() {
		
	}

	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
