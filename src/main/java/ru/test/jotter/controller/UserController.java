package ru.test.jotter.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.test.jotter.repository.UserRepository;
import ru.test.jotter.exception.UserNotFoundException;
import ru.test.jotter.model.User;


@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired()
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> findAllUsers(){
		List<User> list=new ArrayList<User>();
		Iterable<User> userList=this.userRepository.findAll();
		for (User user : userList) {
			list.add(user);
		}
		return list;		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User findOneUser(@PathVariable("id") Long id){
		User user=this.userRepository.findOne(id);
		if(checkUser(id)){
			logger.info("find user with id=" + id);
			return user;
		}
		else{
			throw new UserNotFoundException(id);
		}
	}
	
	@RequestMapping(value="remove/{id}",  method=RequestMethod.DELETE)
	public void removeUser(@PathVariable("id") Long id){
		
		if(checkUser(id)){
			this.userRepository.delete(id);
			logger.info("removed user with id = "+id);
		}
		else{
			throw new UserNotFoundException(id);
		}
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public void addUser(@RequestBody User newUser){
		User user=this.userRepository.save(newUser);
		logger.info("saves new user with id = " + user.getId());
	}
	
	private boolean checkUser(long id){
		return this.userRepository.exists(id);
	}
}