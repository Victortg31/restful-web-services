package com.estudo.rest.webservices.restufulwebservices.controller;
import java.net.URI;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudo.rest.webservices.restufulwebservices.bean.User;
import com.estudo.rest.webservices.restufulwebservices.dao.UserDAO;
import com.estudo.rest.webservices.restufulwebservices.exception.UserNotFoundException;

import org.springframework.boot.autoconfigure.hateoas.*;

@RestController
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDAO.finadAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		
		User user = userDAO.findOne(id);
		
		//verificando se o retorno da requisição o usuário é null
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}

		return user;
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user = userDAO.deleteById(id);
		
		if(user==null) {
			throw new UserNotFoundException("id="+id);
		}
		
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDAO.save(user); 
		 
		//passando qual foi a localização do recurso que foi criado... criando a URI para o local do recursos
		URI  location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}


}
