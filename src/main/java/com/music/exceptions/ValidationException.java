package com.music.exceptions;

public class ValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6930670849339509566L;

	public ValidationException() {
		super();
	}
	
	public ValidationException(String message) {
		super(message);
	}
	
	public ValidationException(Throwable e) {
		super(e);
	}
}
