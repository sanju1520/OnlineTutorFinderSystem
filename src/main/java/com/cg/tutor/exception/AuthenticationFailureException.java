package com.cg.tutor.exception;

public class AuthenticationFailureException extends RuntimeException{
	public AuthenticationFailureException(String msg) {
		super(msg);
	}
}
