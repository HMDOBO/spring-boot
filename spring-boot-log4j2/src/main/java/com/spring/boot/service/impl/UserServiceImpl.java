package com.spring.boot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dao.UserDao;
import com.spring.boot.entity.UserEntity;
import com.spring.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserEntity getUser() {
		LOG.error("== service层日志start ==");
		LOG.trace("trace level");
		LOG.debug("debug level");
		LOG.info("info level");
		LOG.warn("warn level");
		LOG.error("error level");
		LOG.error("== service层日志end ==");
		UserEntity user = userDao.getUser();
		return user;
	}

}
