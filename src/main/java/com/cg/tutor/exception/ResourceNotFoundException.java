package com.cg.tutor.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String msg){
		super(msg);
	}
}
