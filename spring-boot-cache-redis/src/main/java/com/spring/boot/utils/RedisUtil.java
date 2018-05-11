package com.spring.boot.utils;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis操作工具类，核心还是用的RedisTemplate操作redis，
 * 对RedisTemplate操作进行了封装，使用更方便。</p>
 * 
 * 注：
 * 一般对于工具类，通常使用方法都是static静态的，但是Spring是无法管理静态资源的，
 * SpringIOC的思想就是：先初始化各个组件Bean（静态资源先初始化），然后再进行依赖注入，
 * 因此正常情况下，静态资源是无法获取获取SpringIOC容器中的资源，SpringIOC中的组件Bean也无法static静态化.</p>
 * 
 * 也就是在静态方法中无法调用SpringIOC容器中的组件Bean，因此要把SpringIOC容器中
 * 管理的RedisTemplate注入到RedisUtil中，并且其中的静态方法可用，就需要做一些特殊处理.</p>
 * 
 * 使用@PostConstruct注解解决静态资源无法使用SpringIOC中组件Bean问题.</p>
 * 
 * 注解@PostConstruct说明<a>https://blog.csdn.net/asdfghzqlj/article/details/75087724</a>.</p>
 * 
 * 注解@PostConstruct使用在方法上，这个方法需要在依赖注入初始化之后执行，这个方法必须在该服务类使用之前执行。<p/>
 * 
 * 创建时间：2018年5月11日
 */
@Component
public class RedisUtil {
	
	@Autowired
	private RedisTemplate<Object, Object> redis_template;

	private static RedisTemplate<Object, Object> redisTemplate;
	
	// spring 管理bean顺序是先将所有类实例化，再进行依赖注入
	@PostConstruct
    public void init() {
		redisTemplate = redis_template;
    }
	
	// --------------------------------String---------------------------------------
	
	public static void setValue(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}
	
	public static String getValue(String key) {
		return (String) redisTemplate.opsForValue().get(key);
	}
	
    public static void delete(String key){  
        redisTemplate.delete(key);
    }
	
	/** 设置 String 类型 key-value 并添加过期时间 (毫秒单位) */
	public static void setValueWithTimeMS(String key, String value, Long time){
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.MILLISECONDS);
    }
	
	/** 给一个指定的 key值附加过期时间 (毫秒单位) */
	public static boolean expireValueTime(String key, Long timeout) {
		return redisTemplate.boundValueOps(key).expire(timeout, TimeUnit.MILLISECONDS);
	}
	
	// -----------------------------------------------------------------------
	
}
