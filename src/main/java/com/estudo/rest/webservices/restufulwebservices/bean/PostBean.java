package com.estudo.rest.webservices.restufulwebservices.bean;

import java.net.URI;

import org.springframework.stereotype.Component;

@Component
public class PostBean {
	
	private int id;
	private String message;
	private URI location;
	
	public PostBean() {}
	
	public PostBean(int id, String message,URI location ) {
		
		this.id = id;
		this.message = message;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public URI getLocation() {
		return location;
	}
	public void setLocation(URI location) {
		this.location = location;
	}
	
	

}
