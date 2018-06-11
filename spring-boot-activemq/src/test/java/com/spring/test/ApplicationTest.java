package com.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.spring.boot.Application;
import com.spring.boot.entity.UserEntity;
import com.spring.boot.mq.producer.MsgProducerService;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ApplicationTest {

	@Autowired
	private MsgProducerService msgProducerService;
	
	@Test
	public void test() {
		for (int i = 0; i < 200; i++) {
			UserEntity user = new UserEntity();
			user.setId(i);
			user.setUsername("zhang" + i);
			msgProducerService.sendMessage(JSONObject.toJSONString(user));
		}
	}
	
}
