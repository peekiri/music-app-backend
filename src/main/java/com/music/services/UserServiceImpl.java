package com.music.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.entities.User;
import com.music.repositories.UserRepository;
import com.music.serviceinterfaces.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	public String saveNewUser(User user){
		
		
		
		userRepository.save(user);
	}
	
	private boolean checkIfEmailAlreadyExist(User user) {
		
		if(userRepository.countByEmailAddress(user.getEmailAddress()) > 0) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfUserNameAlreadyExist(User user) {
		
		if(userRepository.countByUserName(user.getUserName()) > 0) {
			return true;
		}
		return false;
	}
	
	
}
