package com.example.application.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.entity.User;
import com.example.domain.service.UserService;
import com.example.infrastructure.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	public UserRepository userRepository;
	public UserService userService;
	
	
	@Autowired
	public UserController(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}
	
	
	/**
	 * Retorna uma lista de usuário sem nenhum filtro para consulta.
	 * <p>
	 * Caso não existe nenhum registro o sistema retornará uma lista
	 * vazia.
	 * 
	 * GET method
	 * No context
	 * Header: json/application
	 * 
	 * @return      Lista de usuários
	 * @see         User
	 * 
	 */		
	@RequestMapping(value="findall", method=RequestMethod.GET)
	public Iterable<User> searchAll(){
		return userRepository.findAll();		
	}
	
	
	/**
	 * Salva ou atualiza um usuário
	 * <p>
	 * 
	 * POST method
	 * No context
	 * Header: json/application
	 * 
	 * @see         User
	 * 
	 */		
	@RequestMapping(value="save", method=RequestMethod.POST)
	public void save(@RequestBody User user){
		userService.saveOrUpdateUser(user);		
	}	
	
	/**
	 * Exclui um usuário
	 * <p>
	 * 
	 * POST method
	 * No context
	 * Header: json/application
	 * 
	 * @see         User
	 * 
	 */		
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		userService.deleteUser(id);		
	}	
	
	/**
	 * Retorna uma um usuário pelo id.
	 * <p>
	 * Caso não existe nenhum registro o sistema retornará um NULL
	 * 
	 * GET method
	 * No context
	 * Header: json/application
	 * 
	 * @return      Usuário
	 * @see         User
	 * 
	 */		
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public User  searchById(@PathVariable Long id){
		LOG.info("Search Method");
		return userRepository.findById(id);		
	}
	
}