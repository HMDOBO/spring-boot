package com.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configration {

	@Bean
	public Cache getCache(@Autowired CacheManager cacheManager) {
		return cacheManager.getCache("HelloWorldCache");
	}
	
}
