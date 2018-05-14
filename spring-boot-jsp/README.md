# spring-boot 集成jsp

spring-boot虽然支撑jsp，但是官方不推荐使用jsp，毕竟是快要淘汰的技术

集成步骤:

1. maven添加jsp依赖

		<!--jsp支持 -->
		<!-- servlet 依赖. -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
		<!-- tomcat 的支持. -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>


2. application.properties配置文件添加jsp支持

		#jsp 支持
		spring.mvc.view.suffix=.jsp
		spring.mvc.view.prefix=/WEB-INF/jsp/
		spring.resources.static-locations=classpath:/static/
		
		#关闭默认模板引擎
		spring.thymeleaf.cache=false
		spring.thymeleaf.enabled=false


3. Application.java启动项目，即可