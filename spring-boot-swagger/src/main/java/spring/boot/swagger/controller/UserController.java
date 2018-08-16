package spring.boot.swagger.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import spring.boot.swagger.common.ResponseMessage;
import spring.boot.swagger.entity.UserEntity;

@Api(value="UserController", tags="用户管理")
@RestController
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@ApiOperation(value="获取用户列表", notes="获取所有用户列表")
	@RequestMapping(value="/users", method= RequestMethod.GET)
	public List<User> getUserList() {  
		List<User> users = Arrays.asList(new User("zhangsan", "123456"), new User("lisi", "123456"));
		return users;
	}
	
	@ApiOperation(value="新增用户", notes="新增一个用户",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public String add(@RequestBody UserEntity user) {
		LOG.info(user.toString());
		System.out.println(user);
		return user.toString();
	}
	
	@ApiOperation(value="删除用户")
	@ApiImplicitParam(name="username", value="用户名")
	@RequestMapping(value="/del", method= RequestMethod.GET)
	public ResponseMessage<String> del(String username) {
		return ResponseMessage.ok(null);
	}
	
	@ApiOperation(value="修改用户" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(value="/change", method= RequestMethod.GET)
	public ResponseMessage<String> change(@RequestBody UserEntity user) {
		return ResponseMessage.ok(null);
	}
	
	public class User {
		private String username;
		private String password;
		public User() {
			super();
		}
		public User(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + "]";
		}
	}

}
