package com.spring.boot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.utils.RedisUtil;

import redis.clients.jedis.Jedis;

@RestController
@CrossOrigin
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello !";
	}
	
	@RequestMapping("redis")
	public String redis() {
		return RedisUtil.getValue("key1");
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("192.168.25.201", 6379);
		String string = jedis.get("key1");
		System.out.println(string);
	}
	
}
