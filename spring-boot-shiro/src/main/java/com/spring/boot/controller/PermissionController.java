package com.spring.boot.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permis")
public class PermissionController {
	
	@RequestMapping("/getRole")
	@RequiresPermissions("user:select")
	public String getRole() {
		System.out.println("进入getRole方法");
		return "进入getRole方法，拥有user:select权限";
	}

}
