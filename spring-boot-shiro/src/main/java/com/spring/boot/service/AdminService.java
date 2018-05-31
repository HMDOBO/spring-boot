package com.spring.boot.service;

import java.util.Set;

import com.spring.boot.entity.AdminEntity;

public interface AdminService {
	
	AdminEntity getAdmin(Integer admin_id);
	
	AdminEntity getAdminByUsername(String username);
	
	Set<String> getAdminPermission(Integer admin_id);
	
	String getAdminRole(Integer admin_id);
	
}
