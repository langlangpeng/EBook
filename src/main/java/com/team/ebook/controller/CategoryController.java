package com.team.ebook.controller;

import com.team.ebook.entity.EbookCategory;
import com.team.ebook.service.CategoryService;
import com.team.ebook.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired(required = false)
    private CategoryService categoryService;
    @Autowired(required = false)
    private EbookService ebookService;

    @RequestMapping("/getCategoryByPid")
    @ResponseBody
    public List<EbookCategory> getCategoryByPid(){
        return this.categoryService.getCategoryByParent();
    }

}
