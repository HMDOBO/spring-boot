package com.spring.boot.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.entity.User;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser() {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername("zhangsan");
		user.setPassword("123456");
		return user;
	}
	
	@RequestMapping("/getUserJsp")
	public String getUserJsp(Model model) {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername("lisi");
		user.setPassword("123456");
		model.addAttribute("user", user);
		return "user";
	}
	
	

}
