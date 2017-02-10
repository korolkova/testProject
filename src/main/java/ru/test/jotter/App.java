package ru.test.jotter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.test.jotter.repository.UserRepository;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class App{
		
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);       
    }
}
