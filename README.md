# spring-boot最佳实践

spring-boot工程学习，按模块划分工程结构，spring-boot整合每一个小的功能都单独拿出一个工程，保证每个工程都能独立运行。spring-boot脚手架地址http://start.spring.io/

## 项目工程目录
### 父工程
* spring-boot (spring-boot父工程)

### 基础入门
* spring-boot-quickstart (spring-boot快速使用入门)
* spring-boot-configuration (spring-boot配置文件使用)
* spring-boot-jsp (spring-boot开发jsp页面、同样能发布h5页面)

### 缓存使用
* spring-boot-cache-ehcache (spring-boot整合ehcache缓存框架)
* spring-boot-cache-redis (spring-boot使用redis)

### 数据访问层
* spring-boot-mybatis (spring-boot整合mybatis框架)

### 任务调度
* spring-boot-quartz (spring-boot整合quartz)

### RPC服务调度
* spring-boot-dubbo (spring-boot集成dubbo, 使用官方推荐dubbo-spring-boot-starter)

### 日志记录
* spring-boot-log4j2 (spring-boot使用log4j2记录日志)
