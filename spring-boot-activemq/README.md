# spring-boot整合activeMQ

spring-boot已经自动整合完activeMQ，所以整合比较简单

1. 添加maven依赖

	<!-- activemq -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-activemq</artifactId>
	</dependency>
	<dependency>
		<groupId>org.apache.activemq</groupId>
		<artifactId>activemq-pool</artifactId>
	</dependency>

2. 配置文件ActiveMQConfig，将一个队列Queue注入到ioc容器

3. JmsMessagingTemplate发送消息

4. @JmsListener(destination = "mldn.msg.queue")接受消息
