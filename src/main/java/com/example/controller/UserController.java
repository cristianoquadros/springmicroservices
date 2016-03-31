//package com.example.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.domain.entity.User;
//import com.example.integration.repository.UserRepository;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
//	
//	public UserRepository userRepository;
//
//	@Autowired
//	public UserController(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public Iterable<User> search(){
//		return userRepository.findAll();		
//	}
//	
//	@RequestMapping(method=RequestMethod.POST)
//	public void save(@RequestBody User user){
//		 userRepository.save(user);		
//	}	
//	
//	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
//	public User  searchByDescription(@PathVariable Long id){
//		LOG.info("Search Method");
//		return userRepository.findById(id);		
//	}
//	
////	@RequestMapping(value = "/find/{user}", method=RequestMethod.GET)
////	public List<User>  searchByUser(@PathVariable String user){
////		LOG.info("Search Method");
////		return userRepository.findUsers(user);		
////	}	
//	
////	@RequestMapping(value = "/count/{user}", method=RequestMethod.GET)
////	public Long  searchByUserCount(@PathVariable String user){
////		LOG.info("Search Method");
////		return userRepository.findUsersCount(user);		
////	}		
//	
//}
