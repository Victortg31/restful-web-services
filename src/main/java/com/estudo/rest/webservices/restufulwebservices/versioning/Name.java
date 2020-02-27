package com.estudo.rest.webservices.restufulwebservices.versioning;

public class Name {
	private String firstName;
	private String lastName;
	
	public Name() {};
	
	public Name(String firsString, String lastString) {
		super();
		this.firstName = firsString;
		this.lastName = lastString;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
