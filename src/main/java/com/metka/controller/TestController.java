package com.metka.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metka.entity.User;
import com.metka.service.UserService;

@Controller
public class TestController {
	
	@Resource
	UserService userService;
	
	@GetMapping("/test")
	@ResponseBody
	public User selectByPrimaryKey(int id) {
		return userService.selectByPrimaryKey(id);
	}
}
