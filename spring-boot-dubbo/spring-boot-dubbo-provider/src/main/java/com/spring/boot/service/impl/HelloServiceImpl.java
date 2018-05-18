package com.spring.boot.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.spring.boot.api.HelloService;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello(String name) {
		String result = name + ", Hello, " + "World !";
		return result;
	}

}
