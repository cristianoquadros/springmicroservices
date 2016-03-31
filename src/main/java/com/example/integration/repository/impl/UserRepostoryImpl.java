package com.example.integration.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.entity.User;
import com.example.integration.repository.UserRepositoryCustom;

public class UserRepostoryImpl implements UserRepositoryCustom {		
	private static final long serialVersionUID = 3708363973259424488L;

	public List<User> buscaalgo(String user){
//		Criteria criteria = createCriteria();
//		criteria.add(Restrictions.like(User_.user, user).ignoreCase());
//		return executeCriteria(criteria, 0, 100);	
		return new ArrayList<>();
	}
	
//	public Long buscaUsuariosCount(String user){
//		Criteria criteria = createCriteria();
//		criteria.add(Restrictions.like(User_.user, user).ignoreCase());
//		return executeCriteriaCount(criteria);		
//	}	

}
