package com.spring.boot.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.boot.entity.UserEntity;

@Repository
public class UserDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

	public UserEntity getUser() {
		LOG.error("== dao层日志start ==");
		LOG.trace("trace level");
		LOG.debug("debug level");
		LOG.info("info level");
		LOG.warn("warn level");
		LOG.error("error level");
		LOG.error("== dao层日志end ==");
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setUsername("zhangsan");
		userEntity.setPassword("123456");
		return userEntity;
	}
	
}
