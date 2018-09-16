package com.metka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metka.entity.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
    
    /**
     * 更新标签状态 0禁用 1开启
     * @param status
     * @return
     */
    int updateTagStatus(@Param("status") int status,@Param("tagId") int tagId);
    
    /**
     * 查出所有标签信息
     * @return
     */
    List<Tag> findAllTags();
}