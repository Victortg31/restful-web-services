package com.estudo.rest.webservices.restufulwebservices.bean;

import org.springframework.context.annotation.Bean;

public class HelloWorldBean{
	
	private String message;
	
	

	public HelloWorldBean(String message) {
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	public String getMessage() {
		return message;
	}


	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	
	
}
