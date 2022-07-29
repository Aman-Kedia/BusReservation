package com.bms.exception;

public class PrintExceptionMessage extends Exception {
	
	private static final long serialVersionUID = 1L;
	String message;
	
	public PrintExceptionMessage(String message) {
		super(message);
	}
}
