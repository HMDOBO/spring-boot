package com.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.spring.boot.api.HelloService;

@RestController
public class HelloController {
	
	@Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
	private HelloService helloService;

	@RequestMapping("/sayHello")
    public String sayHello(String name) {
		
        return helloService.sayHello(name);
    }
	
}
