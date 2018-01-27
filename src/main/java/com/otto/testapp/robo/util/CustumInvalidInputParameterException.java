package com.otto.testapp.robo.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustumInvalidInputParameterException extends Exception {

	private static final long serialVersionUID = -8673115775382774630L;

	public CustumInvalidInputParameterException(String message) {
		super(message);
	}
}
