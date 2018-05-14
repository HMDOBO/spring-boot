package com.spring.boot.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.entity.UserEntity;
import com.spring.boot.mapper.UserEntityMapper;
import com.spring.boot.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserEntityMapper userEntityMapper;

	@Override
	@Transactional
	public UserEntity selectOneUser(Long user_id) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(System.currentTimeMillis());
		userEntity.setUserno(UUID.randomUUID().toString());
		userEntity.setUsername("zhangsan");
		userEntity.setUserpwd("123456");
		
		userEntityMapper.insertSelective(userEntity);
		throw new RuntimeException("测试错误");
		
	}

}
