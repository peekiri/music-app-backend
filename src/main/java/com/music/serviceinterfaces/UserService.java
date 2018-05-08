package com.music.serviceinterfaces;

import org.springframework.context.NoSuchMessageException;

import com.music.entities.User;
import com.music.exceptions.EmailAlreadyExistException;
import com.music.exceptions.UsernameAlreadyExistException;

/**
 * User service to save , get the user
 * 
 * @author Vishwas
 *
 */
public interface UserService {

	public void saveNewUser(User user)
			throws NoSuchMessageException, EmailAlreadyExistException, UsernameAlreadyExistException;
	
}
