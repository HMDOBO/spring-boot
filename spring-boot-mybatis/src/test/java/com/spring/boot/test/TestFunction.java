package com.spring.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFunction {
	
	@Autowired
	private Environment env;
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
//		String name = env.getProperty("spring.datasource.name");
//		System.out.println(name);
		System.out.println(userService.selectOneUser(1L));
	}

}
