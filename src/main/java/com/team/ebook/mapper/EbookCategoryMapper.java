package com.team.ebook.mapper;

import com.team.ebook.entity.EbookCategory;
import com.team.ebook.entity.EbookCategoryExample;
import java.util.List;

import com.team.ebook.entity.EbookEntry;
import org.apache.ibatis.annotations.Param;

public interface EbookCategoryMapper {
    int countByExample(EbookCategoryExample example);

    int deleteByExample(EbookCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EbookCategory record);

    int insertSelective(EbookCategory record);

    List<EbookCategory> selectByExample(EbookCategoryExample example);

    EbookCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EbookCategory record, @Param("example") EbookCategoryExample example);

    int updateByExample(@Param("record") EbookCategory record, @Param("example") EbookCategoryExample example);

    int updateByPrimaryKeySelective(EbookCategory record);

    int updateByPrimaryKey(EbookCategory record);

}