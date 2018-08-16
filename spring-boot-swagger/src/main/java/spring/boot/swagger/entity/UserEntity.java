package spring.boot.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="用户实体类")
public class UserEntity {
	
	@ApiModelProperty(value="登录用户名")
	private String username;
	@ApiModelProperty(value="登录密码")
	private String password;
	
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
		return "UserEntity [username=" + username + ", password=" + password + "]";
	}
}
