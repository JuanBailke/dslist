package com.juanbailke.dslist.services.exceptions;

public class InvalidPositionException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidPositionException(String error) {
		super(error);
	}
}
