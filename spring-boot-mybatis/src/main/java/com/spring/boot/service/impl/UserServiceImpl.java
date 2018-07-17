package com.spring.boot.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.entity.GoodsEntity;
import com.spring.boot.entity.UserEntity;
import com.spring.boot.mapper.GoodsEntityMapper;
import com.spring.boot.mapper.UserEntityMapper;
import com.spring.boot.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserEntityMapper userEntityMapper;
	@Autowired
	private GoodsEntityMapper goodsEntityMapper;

	@Override
	@Transactional
	public UserEntity selectOneUser(Long user_id) {
//		UserEntity userEntity = new UserEntity();
//		userEntity.setId(System.currentTimeMillis());
//		userEntity.setUserno(UUID.randomUUID().toString());
//		userEntity.setUsername("zhangsan");
//		userEntity.setUserpwd("123456");
//		
//		userEntityMapper.insertSelective(userEntity);
//		throw new RuntimeException("测试错误");
		goodsEntityMapper.selectByPrimaryKey(1);
		
		LOG.info("================================================");
		LOG.info("================================================");
		
		
		UserEntity user = userEntityMapper.selectByPrimaryKey(user_id);
		LOG.info("================================================");
		
		user.setUsername("lisi");
		userEntityMapper.updateByPrimaryKeySelective(user);
		
		LOG.info("================================================");
		
		return userEntityMapper.selectByPrimaryKey(user_id);
	}
	
	
	@Transactional
	@Override
	public GoodsEntity selectGoods() {
		GoodsEntity goods = goodsEntityMapper.selectByPrimaryKey(1);
		
		LOG.info("***********************************************");
		LOG.info("**************selectGoods方法调用完毕********");
		LOG.info("***********************************************");
		
		return goods;
	}

}
