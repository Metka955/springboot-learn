package com.metka;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.metka.entity.User;
import com.metka.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageHelperTest {
	
	@Resource
	UserMapper userMapper;
	
	@Test
	public void pageHelperTest() {
		
		PageHelper.startPage(2, 2);
		List<User> list = userMapper.findByName("1");
		System.out.println(list);
	}
}
