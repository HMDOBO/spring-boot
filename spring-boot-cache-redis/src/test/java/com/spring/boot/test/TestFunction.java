package com.spring.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.utils.RedisUtil;

import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFunction {
	
//	@Autowired
//	private RedisUtil redisUtil;
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testJedis() {
//		Jedis jedis = new Jedis("192.168.25.111");
//		jedis.set("key1", "value1");
//		System.out.println("缓存成功");
//		System.out.println(jedis.get("key1"));
		
		redisTemplate.opsForValue().set("key1", "value1");
	}
}
