package com.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement	// 启动事务管理
@MapperScan("com.spring.boot.mapper")	// 指定mapper接口包位置
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
