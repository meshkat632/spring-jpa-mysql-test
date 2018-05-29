package com.wagawin.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AttributeNotFoundExcption extends RuntimeException {
	public AttributeNotFoundExcption() {
		super();
	}

	public AttributeNotFoundExcption(String message) {
		super(message);
	}

	public AttributeNotFoundExcption(String message, Throwable cause) {
		super(message, cause);
	}
}