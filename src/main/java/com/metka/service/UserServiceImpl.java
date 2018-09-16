package com.metka.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.metka.entity.User;
import com.metka.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserMapper userMapper;
	
	@Override
	@Cacheable(key="#{username}")
	public List<User> findByName(String username) {
		// TODO Auto-generated method stub
		System.out.println("从数据库查找数据");
		return userMapper.findByName(username);
	}

	@Override
	@Cacheable(cacheNames="hallo")
	public User selectByPrimaryKey(Integer id) {
		
		System.out.println("从数据库查找数据");
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Cacheable
	@Override
	public String cacheTest() {
		System.out.println("从数据库查找数据");
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		return "cache";
	}

}
