package com.spring.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.entity.AdminEntity;
import com.spring.boot.service.AdminService;
import com.spring.boot.utils.JwtUtil;
/**
 * 登录调用service层
 * 
 * 登录成功，返回带有用户id的token
 * 
 * 以后每次加@RequiresAuthentication注解的请求都对RequestHeader中的token信息校验
 * 
 * 创建时间：2018年5月29日
 */
@RestController
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
	public String login(String username, String password) {
		AdminEntity admin = adminService.getAdminByUsername(username);
		if (null == admin) {
			return "用户不存在";
		}
		
		if (!admin.getPassword().equals(password)) {
			return "密码不正确";
		}
		
		// 登录成功，返回生成的token
		return JwtUtil.sign(admin.getId(), admin.getPassword());
	}
	
	/**
	 * 测试@RequiresAuthentication注解是否起作用
	 * @param request
	 * @return
	 */
	@RequestMapping("testShiro")
	@RequiresAuthentication
	public String testShiro(HttpServletRequest request) {
		System.out.println("====进入testShiro===");
		String header = request.getHeader("Authorization");
		return "本次请求的header为" + header;
	}

}
