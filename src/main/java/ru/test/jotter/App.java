package ru.test.jotter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class App{
	
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    } 
}
