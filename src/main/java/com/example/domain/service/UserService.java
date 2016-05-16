package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entity.User;
import com.example.domain.shared.BaseService;
import com.example.infrastructure.repository.UserRepository;

@Service
public class UserService implements BaseService {
	
	private static final long serialVersionUID = 6995972587141007609L;
	
	private UserRepository userRepostitory;
	
	@Autowired
	public UserService(UserRepository userRepostitory){
		this.userRepostitory = userRepostitory;
	}
	
	
	public void saveOrUpdateUser(User user){
		userRepostitory.save(user);
	}
	
	public void deleteUser(Long id){
		userRepostitory.delete(id);
	}	
		
	
	public int metodoUserParaTeste(Long id){
		long valor = userRepostitory.findById(id).getUser().length();
		valor += userRepostitory.count();
		valor += userRepostitory.count();
		valor -= 6;
		
		return Long.valueOf(valor).intValue();
	}
	

}
