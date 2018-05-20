package com.spring.boot.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationTest.class);
	
	@Test
	public void test() {
		LOG.info("==>现在时间是{}", new Date());
		System.out.println("日志记录完毕");
	}
	
}
