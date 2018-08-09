package spring.boot.swagger.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
	
	@ApiOperation(value="获取用户列表", notes="获取所有用户列表",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(value="/users", method= RequestMethod.GET)
	public List<User> getUserList() {  
		List<User> users = Arrays.asList(new User("zhangsan", "123456"), new User("lisi", "123456"));
		return users;
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
	}

}
