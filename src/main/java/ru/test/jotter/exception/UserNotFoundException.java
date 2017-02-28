package ru.test.jotter.exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ComponentScan
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(long id) {
		super("could not find user with id = " + id);
	}
}
