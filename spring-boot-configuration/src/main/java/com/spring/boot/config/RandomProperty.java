package com.spring.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 配置文件.<br/>
 * 使用@Configuration注解，声明这是是个配置类.<br/>
 * 
 * 创建时间：2018年5月4日
 */
@Configuration
@PropertySource("classpath:test.properties")
public class RandomProperty {
	
	@Value("${my.secret}")
	private String randomValue;
	
	@Value("${my.number}")
	private String number;
	
	@Value("${my.uuid}")
	private String uuid;
	

	public String getRandomValue() {
		return randomValue;
	}
	public void setRandomValue(String randomValue) {
		this.randomValue = randomValue;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
