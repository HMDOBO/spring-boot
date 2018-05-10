package com.spring.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFunction {
	
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testJedis() {
		redisTemplate.opsForValue().set("key1", "value1");
		System.out.println("缓存成功");
		System.out.println("key1 = " + redisTemplate.opsForValue().get("key1"));
	}
}
