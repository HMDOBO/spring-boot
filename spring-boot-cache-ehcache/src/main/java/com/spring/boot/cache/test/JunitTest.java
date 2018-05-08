package com.spring.boot.cache.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {
	
	@Autowired
	private CacheManager cacheManager;
	
	@Test
	public void test() {
		// 显示所有的Cache空间
		System.out.println(StringUtils.join(cacheManager.getCacheNames(), ","));
		Cache cache = cacheManager.getCache("HelloWorldCache");
		cache.put("key1", "value1");
		System.out.println("缓存完毕");
		String value = cache.get("key1", String.class);
		System.out.println(value);
	}
	
}
