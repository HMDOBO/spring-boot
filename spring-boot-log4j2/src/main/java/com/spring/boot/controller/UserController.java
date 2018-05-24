package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.entity.UserEntity;
import com.spring.boot.service.UserService;

@RestController
public class UserController {

	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
	public UserEntity getUser() {
		LOG.error("== controller层日志start ==");
		LOG.trace("trace level");
		LOG.debug("debug level");
		LOG.info("info level");
		LOG.warn("warn level");
		LOG.error("error level");
		LOG.error("== controller层日志end ==");
		
		UserEntity userEntity = new UserEntity();
		
		LOG.info("日志记录方式一{}", userEntity);
		LOG.info("日志记录方式二" + userEntity);
		
		return userService.getUser();
	}
	
}
