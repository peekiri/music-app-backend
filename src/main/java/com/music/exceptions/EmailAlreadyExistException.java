package com.music.exceptions;

public class EmailAlreadyExistException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -962072209819587368L;

	public EmailAlreadyExistException () {
		super();
	}
	
	public EmailAlreadyExistException(String message){
		super(message);
	}

	public EmailAlreadyExistException(Throwable e){
			super(e);
	}
}
