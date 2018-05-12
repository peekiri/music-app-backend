package com.music.services;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;

import com.music.entities.User;
import com.music.exceptions.EmailAlreadyExistException;
import com.music.exceptions.UsernameAlreadyExistException;
import com.music.repositories.UserRepository;
import com.music.serviceinterfaces.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	public void saveNewUser(User user) throws NoSuchMessageException, EmailAlreadyExistException,
		UsernameAlreadyExistException {
		
		logger.info("Inside UserServiceImpl , saveNewUser method");
		
		if(checkIfEmailAlreadyExist(user)){
			throw new EmailAlreadyExistException(
					messageSource.getMessage("email.already.exist", null, Locale.ENGLISH));
		}
		if(checkIfUserNameAlreadyExist(user)){
			throw new UsernameAlreadyExistException(
					messageSource.getMessage("username.already.exist", null, Locale.ENGLISH));
		}
		
		userRepository.save(user);
	}
	
	/**
	 * Validate for email existing in database.
	 * 
	 * @param user
	 * @return
	 */
	private boolean checkIfEmailAlreadyExist(User user) {
		
		if(userRepository.countByEmailAddress(user.getEmailAddress()) > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Validate for username if it exist already.
	 * 
	 * @param user
	 * @return
	 */
	private boolean checkIfUserNameAlreadyExist(User user) {
		
		if(userRepository.countByUserName(user.getUserName()) > 0) {
			return true;
		}
		return false;
	}

}
