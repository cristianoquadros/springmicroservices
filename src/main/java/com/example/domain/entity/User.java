package com.example.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.config.layers.BaseEntity;

@Entity
public class User implements BaseEntity{
	private static final long serialVersionUID = 7713394845972669093L;
	
	private  Long id;
	private String user;
	private String pass;
	
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	//Metamodel
	public static class User_ {
	    public static String id = "id";
	    public static String user = "user"; 
	}
}
