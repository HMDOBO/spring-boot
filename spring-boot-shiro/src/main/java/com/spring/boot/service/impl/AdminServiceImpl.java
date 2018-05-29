package com.spring.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.entity.AdminEntity;
import com.spring.boot.mapper.AdminEntityMapper;
import com.spring.boot.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminEntityMapper adminEntityMapper;

	@Override
	public AdminEntity getAdmin(Integer admin_id) {
		return adminEntityMapper.selectByPrimaryKey(admin_id);
	}

	@Override
	public AdminEntity getAdminByUsername(String username) {
		return adminEntityMapper.selectAdminByUsername(username);
	}
	
	
}
