package com.music.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.music.entities.User;
import com.music.mappers.GenericMessageStatusMapper;
import com.music.mappers.UserRequestMapper;
import com.music.serviceinterfaces.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(value="http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<GenericMessageStatusMapper> registerUser(@RequestBody UserRequestMapper bodyPayload) {
		
		GenericMessageStatusMapper statusMapper = new GenericMessageStatusMapper();
		
		User user = new User();
		user.setFirstName(bodyPayload.getFirstName());
		user.setLastName(bodyPayload.getLastName());
		user.setEmailAddress(bodyPayload.getEmailAddress());
		user.setDateOfBirth(bodyPayload.getDateOfBirth());
		user.setPassword(bodyPayload.getPassword());
		user.setPhoneNumber(bodyPayload.getPhoneNumber());
		user.setUserName(bodyPayload.getUserName());
		
		userService.saveNewUser(user);
		
		return null;
	}
}
