package com.music.exceptions;

public class UsernameAlreadyExist extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7257863907017365408L;

	public UsernameAlreadyExist () {
		super();
	}
	
	public UsernameAlreadyExist(String message){
		super(message);
	}

	public UsernameAlreadyExist(Throwable e){
			super(e);
	}
	
}
