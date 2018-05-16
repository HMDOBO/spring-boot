package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;

@SpringBootApplication
@EnableDubboConfig
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		Thread.sleep(Long.MAX_VALUE);
	}
	
}
