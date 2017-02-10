package ru.test.jotter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.test.jotter.repository.UserRepository;

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	@Autowired()
	private UserRepository userRepository;
	
	
	@RequestMapping(value="remove")
	public void removeUser(@RequestParam("id") Integer id){
		
		this.userRepository.delete((long)id);
		logger.info("removed user with id = "+id);
	}

}
