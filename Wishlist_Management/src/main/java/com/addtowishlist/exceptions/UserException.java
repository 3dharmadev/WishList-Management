package com.addtowishlist.exceptions;

public class UserException extends RuntimeException{

	public UserException() {
		
	}
    public UserException(String msg) {
		super(msg);
	}
}
