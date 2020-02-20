package com.example.poc.restws.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1720871595033715840L;

	public UserNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
