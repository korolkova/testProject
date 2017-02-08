package ru.test.jotter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class App{

	//private static final Logger logger = LoggerFactory.getLogger(App.class);
		
	/*@RequestMapping("/user")
    User userById(@RequestParam("id") int id) {
		UserServiceImpl userService=new UserServiceImpl();
		return userService.getUserById(id);
    }*/
	
  	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);       
    }
}
