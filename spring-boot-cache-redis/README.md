# spring-boot整合Redis

### spring-boot配置文件之yml格式

1. YAML 语言（发音 /ˈjæməl/ ）的设计目标，就是方便人类读写。它实质上是一种通用的数据串行化格式
2. YAML基本语法规则
	- 大小写敏感
	- 使用缩进表示层级关系
	- 缩进时不允许使用Tab键，只允许使用空格
	- 缩进的空格数目不重要，只要相同层级的元素左侧对齐即可
	- # 表示注释，从这个字符一直到行尾，都会被解析器忽略
3. YAML 支持的数据结构有三种
	- 对象：键值对的集合，又称为映射、map
	- 数组
	- 复合结构
4. spring-boot默认加载src/main/resources文件夹下面application.yml的配置文件

### 最简单方式spring-boot整合redis
1. 添加maven依赖

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
2. application.yml配置文件中配置redis

		# redis config
		spring:
		  redis:
		    host: 192.168.25.111
		    port: 6379
		    pool:
		     max-idle: 100
		     min-idle: 1
		     max-active: 1000
		     max-wait: -1
3. 这样spring-boot就简单的整合好了redis，使用的话在对应的地方注入RedisTemplate即可

		@RunWith(SpringRunner.class)
		@SpringBootTest
		public class TestFunction {
			@Autowired
			private RedisTemplate redisTemplate;
			@Test
			public void testJedis() {
				redisTemplate.opsForValue().set("key1", "value1");
				System.out.println("缓存成功");
				System.out.println("key1 = " + redisTemplate.opsForValue().get("key1"));
			}
		}
4. 需要注意的是RedisTemplate是spring-data-redis包下的模板类，它在操作redis的时候默认使用JdkSerializationRedisSerializer来进行序列化，所以这样存储后的key和value都会先被序列化后再放入redis，同样取值时key也要先被序列化，再去redis中取值

5. 一般情况下，如没有特殊需求，这样配置redis就可以了，redis就可以正常使用了。具体特殊需求，还需要对RedisTemplate进行特殊处理，然后再注入到Spring IOC，如下

		@Configuration
		public class RedisConfig {
			@Bean
			public RedisTemplate<?, ?> redisTemplate(@Autowired RedisTemplate<?, ?> redisTemplate) {
				redisTemplate.setDefaultSerializer(new StringRedisSerializer());
				return redisTemplate;
			}
		}
上面是对IOC容器中RedisTemplate进行重写，先将IOC中RedisTemplate拿到，然后对其属性进行设置，完成之后，再把RedisTemplate放到IOC容器中。
其实通过在配置类中依赖注入不仅是spring-boot才引进的方式，也是是Spring一直提倡的方式

6. 开发中一般不会直接用RedisTemplate进行redis操作，通常会封装一层RedisUtil用来向redis存取值，封装示例com.spring.boot.utils.RedisUtil


