package com.spring.boot.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.spring.boot.mapper.AdminEntityMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {

	@Autowired
	private AdminEntityMapper adminEntityMapper;
	
	@Test
	public void test() {
//		System.out.println(JSONObject.toJSON(adminEntityMapper.selectByPrimaryKey(1)));
		
		try {
			UsernamePasswordToken usernamePasswordToken = 
					new UsernamePasswordToken("zhangsan", "123456");
			Subject subject = SecurityUtils.getSubject();
			subject.login(usernamePasswordToken);
			System.out.println("==登录成功==");
		} catch (AuthenticationException e) {
			System.out.println("==登录失败==");
			e.printStackTrace();
		}
		
	}
	
	
}
