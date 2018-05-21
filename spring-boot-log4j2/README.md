# spring-boot使用log4j2记录日志

### log4j2的使用及配置详解

Apache Log4j2是对Log4j的升级，与其前身Log4j 1.x相比有了显着的改进，并提供了许多Logback可用的改进，同时解决了Logback体系结构中的一些固有问题。

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
