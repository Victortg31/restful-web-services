package com.estudo.rest.webservices.restufulwebservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rest.webservices.restufulwebservices.bean.Post;
import com.estudo.rest.webservices.restufulwebservices.service.PostService;

@RestController
@RequestMapping("/jpa/users")
public class PostJPAController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> retrieveAllUsers(@PathVariable int id){
		
		return postService.retrieveAllUsers(id);
		
	}
	
	@PostMapping("/{id}/posts")
	public ResponseEntity<Object> createPost(@Valid @PathVariable int id, @RequestBody Post post) {
		
		return postService.createPost(id, post);
	}

}
