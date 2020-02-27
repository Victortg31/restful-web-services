package com.estudo.rest.webservices.restufulwebservices.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//anotação para o Swagger
@ApiModel(description="All details about the user.")
@Entity
public class User {
	
	//ID para a persistencia JPA
	@Id
	//gerando um autoincrement com JPA
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	//Validação para não permitir a data no futuro
	@Past
	//Anotação para o swagger
	@ApiModelProperty(notes="Birth date should be in the past")
	private Date dataAniversario;
	
	// Declarando o relacionamento com o Posts, e passando como parametro qual é o atributo que está relacionando... com isso ele criará essa coluna na tabela de posts
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	public User(int id, String name, Date dataAniversario) {
		this.id = id;
		this.name = name;
		this.dataAniversario = dataAniversario;
	}
	
	public User(String name, Date dataAniversario) {
		
		this.name = name;
		this.dataAniversario = dataAniversario;
	}
	
	protected User() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDataAniversario() {
		return dataAniversario;
	}
	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dataAniversario=" + dataAniversario + "]";
	}
	
	
	
	
}
