# spring-boot整合Mybatis

### 整合步骤

1. 添加maven依赖

		<dependency>
		    <groupId>org.mybatis.spring.boot</groupId>
		    <artifactId>mybatis-spring-boot-starter</artifactId>
		    <version>1.3.0</version>
		</dependency>
		<dependency>
		    <groupId>mysql</groupId>
		    <artifactId>mysql-connector-java</artifactId>
		</dependency>
		<dependency>
		    <groupId>com.alibaba</groupId>
		    <artifactId>druid-spring-boot-starter</artifactId>
		    <version>1.1.0</version>
		</dependency>
		<!-- mybatis generator 自动生成代码插件 -->
		<plugin>
		    <groupId>org.mybatis.generator</groupId>
			<artifactId>mybatis-generator-maven-plugin</artifactId>
			<configuration>
		        <configurationFile>${basedir}/src/main/resources/generator/generatorConfig.xml</configurationFile>
		        <overwrite>true</overwrite>
		        <verbose>true</verbose>
		    </configuration>
		</plugin>

2. spring-boot整合mybatis比较简单，好多都是spring-boot自动化配置了，所以在application.yml中简单配置即可

		# server
		server: 
		  port: 8080
		
		# database数据源配置
		spring:
		    datasource:
		        name: spring-boot-mybatis
		        url: jdbc:mysql://192.168.25.201:3306/edu_demo
		        username: root
		        password: root9918
		        # 使用druid数据源
		        type: com.alibaba.druid.pool.DruidDataSource
		        driver-class-name: com.mysql.jdbc.Driver
		        filters: stat
		        maxActive: 20
		        initialSize: 1
		        maxWait: 60000
		        minIdle: 1
		        timeBetweenEvictionRunsMillis: 60000
		        minEvictableIdleTimeMillis: 300000
		        validationQuery: select 'x'
		        testWhileIdle: true
		        testOnBorrow: false
		        testOnReturn: false
		        poolPreparedStatements: true
		        maxOpenPreparedStatements: 20
		
		# mybatis映射文件存放位置
		mybatis:
		  mapper-locations: classpath:mapping/*.xml
		
		# pagehelper分页插件
		pagehelper:
		    helperDialect: mysql
		    reasonable: true
		    supportMethodsArguments: true
		    params: count=countSql


3. 启动类Application.class添加注解@MapperScan("com.spring.boot.mapper")指定mapper接口包，注解@EnableTransactionManagement启动事务

		@SpringBootApplication
		@EnableTransactionManagement	// 启动事务管理
		@MapperScan("com.spring.boot.mapper")	// 指定mapper接口包位置
		public class Application {
			public static void main(String[] args) {
				SpringApplication.run(Application.class, args);
			}
		}

4. 添加事务支持，除了启动类加@EnableTransactionManagement注解外，对于需要事务支持的方法还需要添加@Transactional注解

		@Override
		@Transactional
		public UserEntity selectOneUser(Long user_id) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(System.currentTimeMillis());
			userEntity.setUserno(UUID.randomUUID().toString());
			userEntity.setUsername("zhangsan");
			userEntity.setUserpwd("123456");
			
			userEntityMapper.insertSelective(userEntity);
			throw new RuntimeException("测试错误");
			
		}

5. 代码自动生成插件mybatis-generator使用，和普通Spring一样的用法，没有区别

6. 这样spring-boot就整合完mybatis了


