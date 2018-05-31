package com.spring.boot.mapper;

import java.util.Set;

import com.spring.boot.entity.AdminEntity;

public interface AdminEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminEntity record);

    int insertSelective(AdminEntity record);

    AdminEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminEntity record);

    int updateByPrimaryKey(AdminEntity record);
    
    AdminEntity selectAdminByUsername(String username);
    
    Set<String> selectAdminPermission(Integer admin_id);
    
    String selectAdminRole(Integer admin_id);
}