package com.spring.boot.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.spring.boot.api.HelloService;

@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello() {
		String result = "Hello, " + "World !";
		return result;
	}

}
