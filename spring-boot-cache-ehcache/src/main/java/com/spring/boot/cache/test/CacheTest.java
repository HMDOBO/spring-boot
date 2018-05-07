package com.spring.boot.cache.test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {
	public static void main(String[] args) {
		// 创建缓存管理器
		CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");
		// 获取缓存对象
		Cache cache = cacheManager.getCache("HelloWorldCache");
		// 创建元素
		Element element = new Element("key1", "value1");
		// 将元素添加到缓存对象里
		cache.put(element);
		
		// 获取缓存
		Element value = cache.get("key1");
		System.out.println(value);
		System.out.println(value.getObjectValue());
		
		// 刷新缓存
		cache.flush();
		
		// 关闭缓存管理器
		cacheManager.shutdown();
		
	}
}
