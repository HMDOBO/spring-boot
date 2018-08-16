package spring.boot.swagger.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import spring.boot.swagger.entity.UserEntity;

@Api(value="LoginController", tags="用户登录注册")
@RestController
public class LoginController {
	
	@ApiOperation(value="登录接口", notes="控制用户登录")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name="username", value="用户名", required=true),
//		@ApiImplicitParam(name="password", value="密码", required=true)
//	})
	@RequestMapping(value="login", method=RequestMethod.POST)
	public UserEntity login(@RequestBody @ApiParam UserEntity user) {
		System.out.println(user);
		return user;
	}

}
