package com.music.exceptions;

public class UsernameAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7257863907017365408L;

	public UsernameAlreadyExistException () {
		super();
	}
	
	public UsernameAlreadyExistException(String message){
		super(message);
	}

	public UsernameAlreadyExistException(Throwable e){
			super(e);
	}
	
}
