package com.metka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.metka.entity.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> findByName(String username);
}