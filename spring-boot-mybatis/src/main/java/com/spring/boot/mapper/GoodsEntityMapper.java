package com.spring.boot.mapper;

import com.spring.boot.entity.GoodsEntity;

public interface GoodsEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsEntity record);

    int insertSelective(GoodsEntity record);

    GoodsEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsEntity record);

    int updateByPrimaryKey(GoodsEntity record);
}