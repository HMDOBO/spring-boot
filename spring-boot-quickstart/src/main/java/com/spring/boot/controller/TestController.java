package com.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hi";
	}
}
