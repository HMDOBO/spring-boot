package com.spring.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.config.RandomProperty;

/**
 * 测试类.<br/>
 * 
 * 创建时间：2018年5月4日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestConfiguration {
	
	@Autowired
	private RandomProperty randomProperty;
	
	@Autowired
	private Environment env;
	
	@Test
	public void test() {
		System.out.println(randomProperty.getRandomValue());
//		System.out.println(randomProperty.getNumber());
//		System.out.println(env.getProperty("my.secret"));
		System.out.println(randomProperty.getUuid());
		
	}
	
}
