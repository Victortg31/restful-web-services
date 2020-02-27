package com.estudo.rest.webservices.restufulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.rest.webservices.restufulwebservices.bean.Post;

public interface PostRespository extends JpaRepository<Post, Integer>{

}
