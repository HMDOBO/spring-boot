# spring-boot配置文件入门

1. spring-boot默认的properties配置文件在src/main/resources目录下的application.properties文件
2. @Configuration注解放在类上面，表示该类是一个配置类
3. 读取配置文件的方式

		第一种
		@Value("${key}") 
		
		第二种
		@Autowired  
		 private Environment env;
		    
		 public static void main() {
		    		syso(env.key);
		 }
4. spring-boot测试类com.spring.boot.test.TestConfiguration
        通过pom文件中添加依赖spring-boot-starter-test
        然后在测试类上添加注解
   @RunWith(SpringRunner.class)
   @SpringBootTest
       在测试类中的方法上添加@Test注解进行单元测试
   
   
	