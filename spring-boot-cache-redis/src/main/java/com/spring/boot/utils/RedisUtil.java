//package com.spring.boot.utils;
//
//import java.io.Serializable;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Component;
//
////@Component
//
////	@SuppressWarnings("rawtypes")
////	@Autowired
////	private RedisTemplate redisTemplate;
//	
////    /** 
////     * 写入缓存 
////     * 
////     * @param key 
////     * @param value 
////     * @return 
////     */  
////    public boolean set(final String key, Object value) {  
////        boolean result = false;  
////        try {  
////            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();  
////            operations.set(key, value);  
////            result = true;  
////        } catch (Exception e) {  
////            e.printStackTrace();  
////        }  
////        return result;  
////    } 
//    
//}
