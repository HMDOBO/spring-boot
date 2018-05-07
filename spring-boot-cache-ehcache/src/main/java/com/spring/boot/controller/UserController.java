package com.spring.boot.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	/**
	 * 放入缓存
	 * @param value
	 * @return
	 */
	@RequestMapping("/setEhcache")
	@CachePut(value = "HelloWorldCache", key = "'key1'")
	public String setEhcache(String value) {
		return value;
	}
	
	/**
	 * 查询缓存
	 * @return
	 */
	@RequestMapping("/getEhcache")
	@Cacheable(value = "HelloWorldCache", key = "'key1'")
	public String getEhcache() {
		return "没有从缓存中获取到value";
	}
	
	/**
	 * 删除缓存
	 * @return
	 */
	@RequestMapping("/delEhcache")
	@CacheEvict(value = "HelloWorldCache", key = "'key1'")
	public String delEhcache() {
		return "删除缓存";
	}
}
