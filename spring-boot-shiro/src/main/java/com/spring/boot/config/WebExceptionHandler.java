package com.spring.boot.config;

import javax.naming.AuthenticationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {

	@ExceptionHandler(AuthenticationException.class)
	public String resolveAuthenticationException(AuthenticationException e) {
		return "AuthenticationException = " + e.getMessage();
	}
	
}
