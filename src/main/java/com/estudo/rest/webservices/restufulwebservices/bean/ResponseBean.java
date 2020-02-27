package com.estudo.rest.webservices.restufulwebservices.bean;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseBean {

	private int id;
	private String message;
	private URI location;

	public ResponseBean() {
	}

	

	public ResponseBean(int id, String message, URI location, ResponseEntity responseEntity) {
		this.id = id;
		this.message = message;
		this.location = location;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public URI getLocation() {
		return location;
	}

	public void setLocation(URI location) {
		this.location = location;
	}
	

	
}
