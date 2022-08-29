package com.team.ebook.service;

import com.github.pagehelper.PageInfo;
import com.team.ebook.entity.EbookEntry;
import com.team.ebook.util.EbookCondition;

public interface EbookService {
    public PageInfo<EbookEntry> getEbookEntryByCondition(EbookCondition ebookCondition);

    public int deleteEbook(Integer id);

    int addEbook(EbookEntry ebookEntry);

    int editEbook(EbookEntry ebookEntry);

    public EbookEntry getEbookEntry(Integer id);

    public int updateEbookEntry(EbookEntry ebookEntry);

    PageInfo<EbookEntry> getEbookEntryByPage(Integer curPage, Integer pageSize);
}
