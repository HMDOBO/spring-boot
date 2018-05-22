package com.spring.boot.dao;

import org.springframework.stereotype.Repository;

import com.spring.boot.entity.UserEntity;

@Repository
public class UserDao {

	public UserEntity getUser() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setUsername("zhangsan");
		userEntity.setPassword("123456");
		return userEntity;
	}
	
}
