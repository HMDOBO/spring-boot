# spring-boot整合Ehcache

### Ehcache简介
ehcache是一个纯Java的进程内缓存框架，快速，精干

### Ehcache 和 Redis 比较
- ehcache直接在jvm虚拟机中缓存，速度快，效率高；但是缓存共享麻烦，集群分布式应用不方便。
- redis是通过socket访问到缓存服务，效率比ecache低，比数据库要快很多，处理集群和分布式缓存方便，有成熟的方案。如果是单个应用或者对缓存访问要求很高的应用，用ehcache。如果是大型系统，存在缓存共享、分布式部署、缓存内容很大的，建议用redis。

### spring-boot整合Ehcache
1. 添加maven依赖

		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-cache</artifactId>
		</dependency>
		<dependency>
		    <groupId>net.sf.ehcache</groupId>
		    <artifactId>ehcache</artifactId>
		</dependency>

2. 在src/main/resources/创建一个配置文件 ehcache.xml
3. 在application.properties配置文件中启用Ehcache，并指定ehcache.xml配置文件地址


		#echache缓存
		spring.cache.type=ehcache
		spring.cache.ehcache.config=classpath:ehcache.xml
4. 在spring-boot主类Application上添加注解@EnableCaching，启动Ehcache
5. spring支持Ehcache注解方式
	- @CachePut 放入缓存，注意格式@CachePut(value = "HelloWorldCache", key = "'key1'")，value表示使用哪个缓存，key表示缓存的key是什么，key中的字符串要用单引号
	- @Cacheable 查询缓存，从Ehcache中查询缓存，@Cacheable(value = "HelloWorldCache", key = "'key1'")
	- @CacheEvict 删除缓存，删除Ehcache中缓存，@CacheEvict(value = "HelloWorldCache", key = "'key1'")
	
```java
/**
 * 放入缓存
 * @param value
 * @return
 */
@RequestMapping("/setEhcache")
@CachePut(value = "HelloWorldCache", key = "'key1'")
public String setEhcache(String value) {
	return value;
}

/**
 * 查询缓存
 * @return
 */
@RequestMapping("/getEhcache")
@Cacheable(value = "HelloWorldCache", key = "'key1'")
public String getEhcache() {
	return "没有从缓存中获取到value";
}

/**
 * 删除缓存
 * @return
 */
@RequestMapping("/delEhcache")
@CacheEvict(value = "HelloWorldCache", key = "'key1'")
public String delEhcache() {
	return "删除缓存";
}
```

### spring-boot 非注解方式使用Ehcache
- 一般情况下spring-boot在annotation的层面实现了数据缓存的功能，基于Spring的AOP技术。所有的缓存配置只是在annotation层面配置，像声明式事务一样。
- 那么要在代码中使用Ehcache，用非注解方式也是可以的。
- Spring定义了CacheManager和Cache接口统一不同的缓存技术。其中CacheManager是Spring提供的各种缓存技术的抽象接口。而Cache接口包含缓存的各种操作。
- 下面采用注入CacheManager的方式，使用Ehcache
```java
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {
	
	@Autowired
	private CacheManager cacheManager;
	
	@Test
	public void test() {
		// 显示所有的Cache空间
		System.out.println(StringUtils.join(cacheManager.getCacheNames(), ","));
		Cache cache = cacheManager.getCache("HelloWorldCache");
		cache.put("key1", "value1");
		System.out.println("缓存完毕");
		String value = cache.get("key1", String.class);
		System.out.println(value);
	}
	
}
```