package com.music.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.music.entities.User;
import com.music.exceptions.EmailAlreadyExistException;
import com.music.exceptions.UsernameAlreadyExistException;
import com.music.exceptions.ValidationException;
import com.music.mappers.GenericMessageStatusMapper;
import com.music.mappers.UserRequestMapper;
import com.music.serviceinterfaces.UserService;
import com.music.validators.RegisterValidator;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private RegisterValidator registerValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<GenericMessageStatusMapper> registerUser(@RequestBody UserRequestMapper bodyPayload,
			BindingResult result) {
		
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
			// validate if proper data is sent to the request before processing further.
			// Validator result will be stored in BindingResult object.
			registerValidator.validate(user, result);
			
			if(result.hasErrors()) {
				throw new ValidationException(messageSource.getMessage("validation.failed", null, Locale.ENGLISH));
			}
			
			userService.saveNewUser(user);
			
			statusMapper.setMessage(messageSource.getMessage("entity.created",null, Locale.ENGLISH));
			statusMapper.setStatus(HttpStatus.ACCEPTED.value());
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("content-type", "application/json")
					.body(statusMapper);
		} catch (NoSuchMessageException | EmailAlreadyExistException | UsernameAlreadyExistException |ValidationException e) {
			
			statusMapper.setMessage(e.getMessage());
			statusMapper.setStatus(HttpStatus.CONFLICT.value());
			
			return ResponseEntity.status(HttpStatus.CONFLICT).header("content-type", "application/json")
					.body(statusMapper);
		}
		
	}
}
