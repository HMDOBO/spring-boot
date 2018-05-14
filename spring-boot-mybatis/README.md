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

	- database数据源配置
	- mybatis映射文件存放位置
	- pagehelper分页插件

3. 启动类Application.class添加注解@MapperScan("com.spring.boot.mapper")指定mapper接口包，注解@EnableTransactionManagement启动事务

		@SpringBootApplication
		@EnableTransactionManagement	// 启动事务管理
		@MapperScan("com.spring.boot.mapper")	// 指定mapper接口包位置
		public class Application {
			public static void main(String[] args) {
				SpringApplication.run(Application.class, args);
			}
		}

4. 代码自动生成插件mybatis-generator使用，和普通Spring一样的用法，没有区别

5. 这样spring-boot就整合完mybatis了


