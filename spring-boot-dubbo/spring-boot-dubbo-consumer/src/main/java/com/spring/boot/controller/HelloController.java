package com.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.spring.boot.api.HelloService;

@RestController
public class HelloController {
	
	// 去掉url = "dubbo://localhost:12345"，添加registry = "${dubbo.registry.id}"，使用zookeeper注册中心
	@Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345"/*,
            registry = "${dubbo.registry.id}"*/)	
	private HelloService helloService;

	@RequestMapping("/sayHello")
    public String sayHello(String name) {
		
        return helloService.sayHello(name);
    }
	
}
