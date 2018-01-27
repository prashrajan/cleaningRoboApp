package com.otto.testapp.robo.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class CustumPathNotException extends Exception {

	private static final long serialVersionUID = -3112963044146857711L;
	
	public CustumPathNotException(String message) {
		super(message);
	}
}
