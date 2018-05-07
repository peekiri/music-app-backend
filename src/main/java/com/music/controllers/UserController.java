package com.music.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.music.entities.User;
import com.music.exceptions.EmailAlreadyExistException;
import com.music.exceptions.UsernameAlreadyExist;
import com.music.mappers.GenericMessageStatusMapper;
import com.music.mappers.UserRequestMapper;
import com.music.serviceinterfaces.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<GenericMessageStatusMapper> registerUser(@RequestBody UserRequestMapper bodyPayload) {
		
		logger.info("Inside UserController , registerUser method");
		
		GenericMessageStatusMapper statusMapper = new GenericMessageStatusMapper();
		
		User user = new User();
		user.setFirstName(bodyPayload.getFirstName());
		user.setLastName(bodyPayload.getLastName());
		user.setEmailAddress(bodyPayload.getEmailAddress());
		user.setDateOfBirth(bodyPayload.getDateOfBirth());
		user.setPassword(bodyPayload.getPassword());
		user.setPhoneNumber(bodyPayload.getPhoneNumber());
		user.setUserName(bodyPayload.getUserName());
		
		try {
			userService.saveNewUser(user);
			
			statusMapper.setMessage("Entites are created");
			statusMapper.setStatus(HttpStatus.ACCEPTED.value());
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(statusMapper);
		} catch (NoSuchMessageException | EmailAlreadyExistException | UsernameAlreadyExist e) {
			
			statusMapper.setMessage(e.getMessage());
			statusMapper.setStatus(HttpStatus.CONFLICT.value());
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(statusMapper);
		}
		
	}
}
