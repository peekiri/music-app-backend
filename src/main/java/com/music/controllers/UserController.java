package com.music.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.music.entities.User;
import com.music.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(value="http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User bodyPayload) {
		
		System.out.println(bodyPayload);
		
		return null;
	}
}
