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
	
		# redis config
		spring:
		  redis:
		    host: 192.168.25.111
		    port: 6379

### 最简单方式spring-boot整合redis
1. 添加maven依赖