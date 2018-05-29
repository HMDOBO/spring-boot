package com.spring.boot.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 类似UsernamePasswordToken对AuthenticationToken的实现.<br/>
 * 
 * 创建时间：2018年5月29日
 */
public class JWTToken implements AuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4294339660924572065L;

	private String token;
	
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return token;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return token;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
