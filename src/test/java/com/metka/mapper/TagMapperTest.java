package com.metka.mapper;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagMapperTest {
	
	@Resource
	TagMapper tagMapper;
	
	@Test
	public void findAllTagsTest() {
		System.out.println(tagMapper.findAllTags());
	}
	
	
}
