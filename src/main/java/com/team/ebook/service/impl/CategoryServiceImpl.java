package com.team.ebook.service.impl;

import com.team.ebook.entity.EbookCategory;
import com.team.ebook.entity.EbookCategoryExample;
import com.team.ebook.entity.EbookEntry;
import com.team.ebook.mapper.EbookCategoryMapper;
import com.team.ebook.mapper.EbookEntryMapper;
import com.team.ebook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private EbookCategoryMapper ebookCategoryMapper;
    @Override
    public List<EbookCategory> getCategoryByParent() {
        EbookCategoryExample ebookCategoryExample = new EbookCategoryExample();
        EbookCategoryExample.Criteria criteria = ebookCategoryExample.createCriteria();

        return ebookCategoryMapper.selectByExample(ebookCategoryExample);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED )
    public List<EbookCategory> getAllCategory() {
        return this.ebookCategoryMapper.selectByExample(new EbookCategoryExample());
    }

}
