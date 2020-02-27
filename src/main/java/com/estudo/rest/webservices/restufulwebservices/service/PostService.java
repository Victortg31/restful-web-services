package com.estudo.rest.webservices.restufulwebservices.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudo.rest.webservices.restufulwebservices.bean.Post;
import com.estudo.rest.webservices.restufulwebservices.bean.PostBean;
import com.estudo.rest.webservices.restufulwebservices.bean.User;
import com.estudo.rest.webservices.restufulwebservices.exception.UserNotFoundException;
import com.estudo.rest.webservices.restufulwebservices.repository.PostRespository;
import com.estudo.rest.webservices.restufulwebservices.repository.UserRespository;

@Service
public class PostService {
	
	@Autowired
	private PostBean postBean;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private PostRespository postRespository;
	
	
	public ResponseEntity<List<Post>> retrieveAllUsers(int id){
		
		Optional<User> userOptional = userService.retrieveUser(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id - "+ id);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(userOptional.get().getPosts());
		
		
	}
	
	public ResponseEntity<Object> createPost(int id, Post post) {
		
		Optional<User> userOptional = userRespository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id - "+ id);
		}
		
		User user = userOptional.get();
		
		URI  location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		
		post.setUser(user);
		
		postBean.setId(user.getId());
		postBean.setMessage("Post Criado com sucesso");
		postBean.setLocation(location);
		
		
		postRespository.save(post);
		
		//passando qual foi a localização do recurso que foi criado... criando a URI para o local do recursos
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(postBean);
	}

}
