package com.metka.service;

import java.util.List;

import com.metka.entity.User;

public interface UserService {
	
	List<User> findByName(String username);
	
    User selectByPrimaryKey(Integer id);
    
    String cacheTest();

}
