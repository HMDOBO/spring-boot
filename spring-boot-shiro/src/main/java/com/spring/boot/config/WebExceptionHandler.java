package com.spring.boot.config;


import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {

	/**
	 * token 校验失败异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler({AuthorizationException.class})
	public String resolveAuthenticationException(Exception e) {
		return "token 验证失败，请重新登录";
	}
	
}
