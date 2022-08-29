package com.team.ebook.mapper;

import com.team.ebook.entity.EbookEntry;
import com.team.ebook.entity.EbookEntryExample;
import java.util.List;

import com.team.ebook.util.EbookCondition;
import org.apache.ibatis.annotations.Param;

public interface EbookEntryMapper {
    int countByExample(EbookEntryExample example);

    int deleteByExample(EbookEntryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EbookEntry record);

    int insertSelective(EbookEntry record);

    List<EbookEntry> selectByExample(EbookEntryExample example);

    EbookEntry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EbookEntry record, @Param("example") EbookEntryExample example);

    int updateByExample(@Param("record") EbookEntry record, @Param("example") EbookEntryExample example);

    int updateByPrimaryKeySelective(EbookEntry record);

    int updateByPrimaryKey(EbookEntry record);

    List<EbookEntry> getEbookEntryCondition(EbookCondition ebookCondition);

    EbookEntry selectByPrimaryKey2(Integer id);
}