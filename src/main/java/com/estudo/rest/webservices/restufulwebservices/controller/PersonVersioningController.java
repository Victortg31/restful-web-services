package com.estudo.rest.webservices.restufulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rest.webservices.restufulwebservices.versioning.Name;
import com.estudo.rest.webservices.restufulwebservices.versioning.PersonV1;
import com.estudo.rest.webservices.restufulwebservices.versioning.PersonV2;

@RestController
public class PersonVersioningController {
	
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
}
