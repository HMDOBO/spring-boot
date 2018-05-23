# spring-boot使用log4j2记录日志

### log4j2的使用及配置详解

Apache Log4j2是对Log4j的升级，与其前身Log4j 1.x相比有了显着的改进，并提供了许多Logback可用的改进，同时解决了Logback体系结构中的一些固有问题。

### 使用log4j2

1. 添加maven依赖

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
		<exclusions>
			<exclusion><!-- 去掉默认配置 -->
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-logging</artifactId>
			</exclusion>
		</exclusions>
	</dependency>
	
	<!-- log4j2 -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-log4j2</artifactId>
	</dependency>

2. 配置log4j2.xml配置文件，下面介绍配置文件

3. 在类中使用log4j2，Logger为slf4j的，LoggerFactory也是slf4j的；

	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	LOG.info("日志记录方式一{}", userEntity);
	LOG.info("日志记录方式二" + userEntity);

4. slf4j是log日志的一种记录规范，是api，它本身没有日志记录的功能，

#### log4j2配置文件

1. log4j2默认加载多种格式的配置文件，最常用的是log4j2.xml文件名的配置文件

2. log4j2.xml默认的配置内容是下面的，也就是当不存在log4j2.xml文件时，也会使用该配置

		<?xml version="1.0" encoding="UTF-8"?>
		<Configuration status="WARN">
			<Appenders>
				<Console name="Console" target="SYSTEM_OUT">
					<PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
				</Console>
			</Appenders>
			<Loggers>
				<Root level="error">
					<AppenderRef ref="Console" />
				</Root>
			</Loggers>
		</Configuration>

3. 
