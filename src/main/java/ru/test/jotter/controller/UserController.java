package ru.test.jotter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.test.jotter.repository.UserRepository;


@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired()
	private UserRepository userRepository;
	
	
	@RequestMapping(value="remove")
	public void removeUser(@RequestParam("id") Integer id){
		
		if(checkUser(id)){
			this.userRepository.delete((long)id);
			logger.info("removed user with id = "+id);
		}
		else{
			/*logger.info("could not find user with id = " + id);*/
			throw new UserNotFoundException(id);
		}
	}
	
	private boolean checkUser(long id){
		return this.userRepository.exists(id);
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(long id) {
		super("could not find user with id = " + id);
	}
}
