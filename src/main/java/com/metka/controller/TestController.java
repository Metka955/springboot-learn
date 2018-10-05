package com.metka.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metka.annotation.Valid;
import com.metka.annotation.Valids;
import com.metka.config.DelaySender;
import com.metka.entity.Order;
import com.metka.entity.People;
import com.metka.entity.User;
import com.metka.enums.ResponseCode;
import com.metka.result.Result;
import com.metka.service.UserService;

@Controller
public class TestController {

	@Resource
	UserService userService;

	@Autowired
	private DelaySender delaySender;

	@PostMapping("/selectByPrimaryKey")
	@ResponseBody
	public Result<User> selectByPrimaryKey() {
		
		
		User user = userService.selectByPrimaryKey(1);
		
		
		Result<User> result=new Result<User>();
		result.setData(user);
		result.setResponseCode(ResponseCode.SUCCESS);
		return result;
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		User user = userService.selectByPrimaryKey(1);
		userService.findByName("1");
		if(user==null) {
			return "111";
		}
		return "aaa";
	}
	
	@RequestMapping(value = "/first", method = RequestMethod.GET)  
	@ResponseBody
    public Map<String, Object> firstResp (HttpServletRequest request){  
        Map<String, Object> map = new HashMap<>();  
        request.getSession().setAttribute("request Url", request.getRequestURL());  
        map.put("request Url", request.getRequestURL());  
        return map;  
    }  
  
    @RequestMapping(value = "/sessions", method = RequestMethod.GET)  
    @ResponseBody
    public Object sessions (HttpServletRequest request){  
        Map<String, Object> map = new HashMap<>();  
        map.put("sessionId", request.getSession().getId());  
        map.put("message", request.getSession().getAttribute("map"));  
        return map;  
    }  
}
