package com.metka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metka.entity.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    /**
     * 更新商品标签信息
     * @param id
     * @param tagId
     * @return
     */
    int updateTagId(@Param("id") int id,@Param("tagId") int tagId);
    
    /**
     * 把所有商品标签为tagId都重置为空 0
     * @param tagId
     * @return
     */
    int resetTagId(@Param("tagId") int tagId);
    
    /**
     * 批量更新ids商品里的tagId
     * @param ids
     * @return
     */
    int batchUpdateTagId(@Param("ids") List<Integer> ids,@Param("tagId") int tagId);
}