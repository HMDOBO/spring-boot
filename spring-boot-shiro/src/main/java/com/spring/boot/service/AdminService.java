package com.spring.boot.service;

import com.spring.boot.entity.AdminEntity;

public interface AdminService {
	
	public AdminEntity getAdmin(Integer admin_id);
	
	public AdminEntity getAdminByUsername(String username);
}
