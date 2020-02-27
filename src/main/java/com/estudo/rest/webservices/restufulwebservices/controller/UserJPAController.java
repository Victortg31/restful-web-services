package com.estudo.rest.webservices.restufulwebservices.controller;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudo.rest.webservices.restufulwebservices.bean.Post;
import com.estudo.rest.webservices.restufulwebservices.bean.ResponseBean;
import com.estudo.rest.webservices.restufulwebservices.bean.User;
import com.estudo.rest.webservices.restufulwebservices.dao.UserDAO;
import com.estudo.rest.webservices.restufulwebservices.exception.UserNotFoundException;
import com.estudo.rest.webservices.restufulwebservices.repository.PostRespository;
import com.estudo.rest.webservices.restufulwebservices.repository.UserRespository;
import com.estudo.rest.webservices.restufulwebservices.service.UserService;

@RestController
@RequestMapping("/jpa/users")
public class UserJPAController {
	
	
	@Autowired
	UserService userService;
	
	
	//usando o repositorio criado
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private PostRespository postRepository;
	
	
	@GetMapping("/")
	public List<User> retrieveAllUsers(){
		return userService.retrieveAllUsers();
	}
	 
	@GetMapping("/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		
		return userService.retrieveUser(id);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBean> deleteUser(@PathVariable int id) {
		
		return userService.deleteUser(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<ResponseBean> createUser(@Valid @RequestBody User user) {
		
		User savedUser = userRespository.save(user); 
		
		return userService.createUser(savedUser);
	}
	

}
