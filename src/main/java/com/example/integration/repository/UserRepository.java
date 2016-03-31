package com.example.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	@Query("select u from User u where LOWER(u.user) like LOWER(?1)")
	List<User> searchByUser(String user);

	User findById(Long id);
}
