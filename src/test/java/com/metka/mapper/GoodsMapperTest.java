package com.metka.mapper;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsMapperTest {
	
	@Resource
	GoodsMapper goodsMapper;
	
	@Test
	public void updateTagIdTest() {
		goodsMapper.updateTagId(1, 2);
	}
	
	@Test
	public void resetTagIdTest() {
		goodsMapper.resetTagId(1);
	}
	
	@Test
	public void batchUpdateTagId() {
		ArrayList<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		goodsMapper.batchUpdateTagId(ids, 4);
	}
}
