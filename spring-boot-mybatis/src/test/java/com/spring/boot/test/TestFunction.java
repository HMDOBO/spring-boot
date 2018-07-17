package com.spring.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.entity.GoodsEntity;
import com.spring.boot.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFunction {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		
		/**
		 * 测试sqlsession作用域
		 */
		
		GoodsEntity goods = userService.selectGoods();
		
		System.out.println(userService.selectOneUser(1L));
	}

}
