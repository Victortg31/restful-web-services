package com.estudo.rest.webservices.restufulwebservices.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudo.rest.webservices.restufulwebservices.bean.ResponseBean;
import com.estudo.rest.webservices.restufulwebservices.bean.User;
import com.estudo.rest.webservices.restufulwebservices.exception.UserNotFoundException;
import com.estudo.rest.webservices.restufulwebservices.repository.UserRespository;

@Service
public class UserService {

	@Autowired
	UserRespository userRespository;

	@Autowired
	ResponseBean responseBean;

	public ResponseEntity<ResponseBean> createUser(User user) {

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();

		userRespository.save(user);

		responseBean.setId(user.getId());
		responseBean.setMessage("Usuario Criado com sucesso");
		responseBean.setLocation(location);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseBean);
	}

	public List<User> retrieveAllUsers() {
		return userRespository.findAll();
	}

	public Optional<User> retrieveUser(int id) {

		Optional<User> user = userRespository.findById(id);

		// verificando se o retorno da requisição o usuário é null
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return user;
	}

	
	public ResponseEntity<ResponseBean> deleteUser(int id) {
		
		responseBean.setId(id); 
		responseBean.setMessage("Usuario deletado com sucesso");
		
		userRespository.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseBean);
	}

}
