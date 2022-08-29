package com.team.ebook.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.ebook.entity.EbookEntry;
import com.team.ebook.entity.EbookEntryExample;
import com.team.ebook.mapper.EbookEntryMapper;
import com.team.ebook.service.EbookService;
import com.team.ebook.util.EbookCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {
    @Autowired(required = false)
    private EbookEntryMapper ebookEntryMapper;

    @Override
    public PageInfo<EbookEntry> getEbookEntryByCondition(EbookCondition ebookCondition) {
        PageHelper.startPage(ebookCondition.getPage(),ebookCondition.getPageSize());
        List<EbookEntry> list = ebookEntryMapper.getEbookEntryCondition(ebookCondition);
        return new PageInfo<EbookEntry>(list);
    }

    @Override
    public int deleteEbook(Integer id) {
        return ebookEntryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addEbook(EbookEntry ebookEntry) {
        return ebookEntryMapper.insertSelective(ebookEntry);
    }

    @Override
    public int editEbook(EbookEntry ebookEntry) {
        return ebookEntryMapper.updateByPrimaryKeySelective(ebookEntry);
    }

    @Override
    public EbookEntry getEbookEntry(Integer id) {
        return ebookEntryMapper.selectByPrimaryKey2(id);
    }

    @Override
    public int updateEbookEntry(EbookEntry ebookEntry) {
        return this.ebookEntryMapper.updateByPrimaryKeySelective(ebookEntry);
    }

    @Override
    public PageInfo<EbookEntry> getEbookEntryByPage(Integer curPage, Integer pageSize) {
        PageHelper.startPage(curPage,pageSize);
        EbookEntryExample ebookEntryExample = new EbookEntryExample();
        List<EbookEntry> list = this.ebookEntryMapper.selectByExample(ebookEntryExample);
        PageInfo<EbookEntry> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
