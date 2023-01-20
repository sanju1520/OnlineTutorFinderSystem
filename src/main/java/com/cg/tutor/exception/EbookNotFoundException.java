package com.cg.tutor.exception;

public class EbookNotFoundException extends RuntimeException{
	public EbookNotFoundException(String msg) {
        super(msg);
    }
}
