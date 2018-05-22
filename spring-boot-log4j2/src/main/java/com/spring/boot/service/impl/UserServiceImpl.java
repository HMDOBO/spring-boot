package com.spring.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dao.UserDao;
import com.spring.boot.entity.UserEntity;
import com.spring.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserEntity getUser() {
		UserEntity user = userDao.getUser();
		System.err.println("UserEntity信息" + user);
		return user;
	}

}
