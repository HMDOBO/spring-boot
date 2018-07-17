package com.spring.boot.service;

import com.spring.boot.entity.GoodsEntity;
import com.spring.boot.entity.UserEntity;

public interface UserService {

	UserEntity selectOneUser(Long user_id);
	public GoodsEntity selectGoods();
	
}
