package com.spring.boot.config;


import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
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
		
		System.out.println("===无登录权限异常===");
		
		return "token 验证失败，请重新登录";
	}
	
	
	@ExceptionHandler({UnauthorizedException.class})
	public String resolveUnauthorizedException(Exception e) {
		
		System.out.println("===无操作权限异常===");
		
		return "token 权限不足，无法操作当前接口";
	}
	
}
