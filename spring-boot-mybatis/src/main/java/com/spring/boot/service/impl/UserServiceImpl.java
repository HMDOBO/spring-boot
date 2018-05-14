package com.spring.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.entity.UserEntity;
import com.spring.boot.mapper.UserEntityMapper;
import com.spring.boot.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserEntityMapper userEntityMapper;

	@Override
	public UserEntity selectOneUser(Long user_id) {
		return userEntityMapper.selectByPrimaryKey(user_id);
	}

}
