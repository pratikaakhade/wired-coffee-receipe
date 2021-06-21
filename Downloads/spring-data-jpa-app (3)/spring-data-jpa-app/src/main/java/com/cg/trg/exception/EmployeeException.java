package com.cg.trg.exception;

//Custom checked exception
public class EmployeeException extends Exception{

	public EmployeeException() {

	}

	public EmployeeException(String errMessage) {
		super(errMessage);
	}

	public EmployeeException(String errMessage, Throwable t) {
		super(errMessage,t);
	}
}
