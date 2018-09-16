package com.metka.mapper;

import com.metka.entity.TagGoods;

public interface TagGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagGoods record);

    int insertSelective(TagGoods record);

    TagGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagGoods record);

    int updateByPrimaryKey(TagGoods record);
}