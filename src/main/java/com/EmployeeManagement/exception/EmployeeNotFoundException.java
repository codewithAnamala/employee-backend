package com.EmployeeManagement.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException (String msg) {
		super(msg);
	}
}
