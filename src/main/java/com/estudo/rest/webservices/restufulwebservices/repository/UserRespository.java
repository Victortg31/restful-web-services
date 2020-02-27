package com.estudo.rest.webservices.restufulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudo.rest.webservices.restufulwebservices.bean.User;

@Repository
public interface UserRespository extends JpaRepository<User, Integer>{

}
