package com.spring.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.utils.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFunction {

	@Test
	public void testJedis() {
//		redisTemplate.opsForValue().set("key3", "value3");
//		System.out.println("缓存成功");
//		System.out.println("key3 = " + redisTemplate.opsForValue().get("key3"));
//		RedisUtil.setValue("key1", "value1");
//		System.out.println("缓存成功");
//		System.out.println(RedisUtil.getValue("key1"));
//		RedisUtil.setValueWithTimeMS("key2", "value2", 1000 * 60L);
//		RedisUtil.expireValueTime("key1", 1000 * 30L);
		RedisUtil.setValue("key1", "value1");
		RedisUtil.delete("key1");
	}

}
