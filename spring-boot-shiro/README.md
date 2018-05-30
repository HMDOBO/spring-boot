# spring-boot-shiro

### 参考

- 关于用户-角色-权限设计，有著名的RBAC(Role-Base-Access-Controller)基于角色的权限访问控制
- 相关博客：https://blog.csdn.net/yangwenxue_admin/article/details/73936803

### 本项目设计

	后台管理员：admin
	
	角色：role
		系统管理员
		用户管理员
		商品管理员
		订单管理员
	
	权限：permission
		是根据资源权限一一对应的，因此主要关注具体资源权限
	
	资源权限：resource
		（其实资源和权限本来就容易混淆，这样设计可以淡化资源和权限的概念）	
		菜单资源：menu	（菜单权限只需要授权具体的菜单页面就可以了，无需授权父菜单）
			首页菜单
			用户管理菜单
			商品管理菜单
				数码电子商品管理菜单
					手机管理菜单
					电脑管理菜单
				衣装服饰商品管理菜单
			订单管理菜单
				在线支付订单菜单
				货到付款订单菜单
			系统管理菜单
				管理员管理菜单
				角色管理菜单
				权限管理菜单
			个人信息菜单
		功能操作权限资源：operation（基于接口的，是用户操作权限，和菜单并无关系，和菜单资源解耦）
			用户管理：增删改查
			商品管理：增删改查
			订单管理：删改查
			系统管理：增删改查
			个人信息：改查

### 关于jwt的方式使用shiro
1. 因为jwt是无状态的，所以在使用shiro方面和传统的session不一样，登录认证和权限认证都有所不同

2. 大体执行流程
	* 用户登录 -> 调用service判断用户是否登录成功  -> 登录成功生成token返回给接口调用者
	* 用户登录完成，请求头携带token -> shiro拦截器Filter拦截请求 -> 判断token是否可用
	* token可用 -> 表示有登录权限 -> 从token中取出用户id -> 根据用户id查询用户权限信息
	* 整个jwt方式使用shiro大致完成
	
### 全部spring-boot + shiro + jwt使用步骤

本工程受gitHub上项目https://github.com/Smith-Cruise/Spring-Boot-Shiro/ 的启发，一些功能搬运过来，并进行特性化改造，更接近前后端分离项目，同时也添加了权限认证功能。

1. maven添加依赖

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!-- shiro -->
		<dependency>
		    <groupId>org.apache.shiro</groupId>
		    <artifactId>shiro-spring</artifactId>
		    <version>1.3.2</version>
		</dependency>
		<!-- jwt -->
		<dependency>
		    <groupId>com.auth0</groupId>
		    <artifactId>java-jwt</artifactId>
		    <version>3.2.0</version>
		</dependency>

2. 可能是spring-boot内部并没有对shiro进行整合，spring脚手架上面也没有对shiro的整合，所以只能全手工配置的方式，将shiro注入到spring容器中。本工程模拟真实场景，采用真实数据库，整合了mybatis。

3. 所有的配置都放到com.spring.boot.shiro包下
	* spring-boot整合shiro支持，com.spring.boot.shiro.config.ShiroConfig类
		* 首先配置SecurityManager安全管理器，这是核心，其中包括自定义realm后面具体介绍
		* 配置ShiroFilter过滤器，默认过滤器并不适合前后端分离项目中RequestHeader中传递token，因此还需重写BasicHttpAuthenticationFilter，配置自定义Filter，自定义Filter后面具体介绍
		* 最后，配置shiro注解支持，这个比较简单
	* 配置JWTToken用于传递token值，实现AuthenticationToken
	* 配置自定义Filter，关于Filter，因为以前没有重写过过滤器，对源码也没有研究，所以，这个配置基本从别的地方复制过来了，以后有时间看看，但是这也是核心
	* 配置自定义realm，com.spring.boot.shiro.realm.MyRealm类
		* 首先配置doGetAuthenticationInfo方法，要注意该方法因为是在Subject.login(token)的时候调用，而传统的session会话项目会在登录的时候调用Subject.login()方法。但是通过token的方式，就不在登录的时候调用Subject.login()方法了，而是在token可用性校验的时候调用
		* 重写supports(AuthenticationToken token)方法
		* doGetAuthorizationInfo授权方法后面介绍
	* 配置完毕，基本的使用方式在com.spring.boot.controller.LoginController类中，一个登录，一个测试请求头需要token(类似session会话中的登录状态)。
		* 登录使用自己的逻辑，不用shiro的，登录成功后生成token，返回给登录调用者
		* 测试请求头需要可用token(类似session会话中的登录状态)才能调用接口，在方法上加注解@RequiresAuthentication，这样就可以了







