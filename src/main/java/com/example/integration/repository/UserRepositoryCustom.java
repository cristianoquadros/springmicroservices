package com.example.integration.repository;

import java.util.List;

import com.example.domain.entity.User;


public interface UserRepositoryCustom {
	
	List<User> buscaalgo(String user);
	
//	Long buscaUsuariosCount(String user);
	
}
