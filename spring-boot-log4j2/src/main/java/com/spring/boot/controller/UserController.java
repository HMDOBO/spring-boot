package com.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.entity.UserEntity;
import com.spring.boot.service.UserService;

@RestController
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
	public UserEntity getUser() {
		LOG.trace("trace level");
		LOG.debug("debug level");
		LOG.info("info level");
		LOG.warn("warn level");
		LOG.error("error level");
		return userService.getUser();
	}
	
}
