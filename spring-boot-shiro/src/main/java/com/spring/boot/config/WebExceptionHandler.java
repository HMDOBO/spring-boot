package com.spring.boot.config;


import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {

	@ExceptionHandler({AuthorizationException.class})
	public String resolveAuthenticationException(Exception e) {
		return "AuthenticationException = " + e.getMessage();
	}
	
}
