package com.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类，可以按需求进行个性化配置
 * 
 * 一般spring-boot整合redis不需要该配置就能使用
 * 
 * 但是，通常来说还是要有这个配置，来应对个性化需求<br/>
 * 
 * 创建时间：2018年5月11日
 */
//@Configuration
public class RedisConfig {

	/**
	 * 对于默认的RedisTemplate，DefaultSerializer是JdkSerializationRedisSerializer
	 * 
	 * 不是很好用，尤其在使用redis的incr命令时，JdkSerializationRedisSerializer无法使用，可能是一个bug吧
	 * 
	 * 因此，正常情况下还是使用StringRedisSerializer，把默认的RedisSerializer替换掉
	 */
	@Bean
	public RedisTemplate<?, ?> redisTemplate(@Autowired RedisTemplate<?, ?> redisTemplate) {
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
	
}
