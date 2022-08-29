package com.team.ebook.service;

import com.team.ebook.entity.EbookCategory;
import com.team.ebook.entity.EbookEntry;

import java.util.List;

public interface CategoryService {
    List<EbookCategory> getCategoryByParent();
    public List<EbookCategory> getAllCategory();

}
