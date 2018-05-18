package com.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类，一般spring-boot整合redis不需要该配置，如果有特殊需求，可以配置.<br/>
 * 
 * 创建时间：2018年5月11日
 */
//@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<?, ?> redisTemplate(@Autowired RedisTemplate<?, ?> redisTemplate) {
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
	
}
