package com.estudo.rest.webservices.restufulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rest.webservices.restufulwebservices.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	
	// GET
	// URI - /hello-world
	//Método hellow world
	
	@GetMapping(path="/hello-world")
	public String helloWordl() {
		return "Hello World normal";
	}
	
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("HELLO WORLD PELA BEAN");
	}
	
	@GetMapping(path= "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	@GetMapping(path = "/hello-world-bean-internationalized")
	public HelloWorldBean helloWorldInternationalized() {
		return new HelloWorldBean("HELLO WORLD internationalized");
	}
	

	
}
