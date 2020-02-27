package com.estudo.rest.webservices.restufulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.estudo.rest.webservices.restufulwebservices.bean.User;

// Colocando a classe como administradora
@Component
public class UserDAO {
	
	private static List<User> users = new ArrayList<User>();
	private static int usersCont = 4;
	
	static {
		users.add(new User(1,"Victor", new Date()));
		users.add(new User(2,"Ivan", new Date()));
		users.add(new User(3,"Alexandre", new Date()));
		users.add(new User(4,"Patrick", new Date()));
	}
	
	
	public List<User> finadAll(){
		
		return users;
	}
	
	
	public User save(User user) {
		
		if(user.getId() == 0) {
			user.setId(++usersCont);
		}
		
		users.add(user);
		
		return user; 
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	public User deleteById(int id) {
		
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
}
