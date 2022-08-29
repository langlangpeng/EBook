package com.team.ebook.controller;

import com.github.pagehelper.PageInfo;
import com.team.ebook.entity.EbookEntry;
import com.team.ebook.service.CategoryService;
import com.team.ebook.service.EbookService;
import com.team.ebook.util.EbookCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EbookController {
    @Autowired(required = false)
    private EbookService ebookService;
    @Autowired(required = false)
    private CategoryService categoryService;

    @RequestMapping("/searchEbook")
    public String searchEbook(EbookCondition ebookCondition, Model model){
        PageInfo<EbookEntry> pageInfo = ebookService.getEbookEntryByCondition(ebookCondition);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("condition",ebookCondition);
        return "index";
    }
    @RequestMapping("/getPageEbookEntryByPage")
    public String getPageStudent(Integer pageNum,Model model){
        PageInfo<EbookEntry> pageInfo = this.ebookService.getEbookEntryByPage(pageNum==null?1:pageNum,5);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
//    @RequestMapping("/goAddEbook")
//    public String goAddEbook(EbookCondition ebookCondition, Model model){
//        PageInfo<EbookEntry> pageInfo = ebookService.getEbookEntryByCondition(ebookCondition);
//        model.addAttribute("pageInfo",pageInfo);
//        model.addAttribute("condition",ebookCondition);
//        return "addEbook";
//    }
    @RequestMapping("/deleteebook")
    public String deleteebook(Integer id){
        ebookService.deleteEbook(id);
        return "redirect:searchEbook";
    }
    @RequestMapping("/goaddebook")
    public String goaddebook(EbookEntry ebookEntry){
        int i = this.ebookService.addEbook(ebookEntry);
        if (i>0){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
        return "index";
    }

    @RequestMapping("/editebook")
    public String editebook(Integer id,Model model){
        EbookEntry ebookEntry = this.ebookService.getEbookEntry(id);
        model.addAttribute("ebookEntry",ebookEntry);
        return "editEbook";
    }
    @RequestMapping("/updateeditebook")
    public String updateStudent(EbookEntry ebookEntry){
        try{
            this.ebookService.updateEbookEntry(ebookEntry);
            return "index";
        }catch (Exception e){
            return "redirect:editebook?id="+ebookEntry.getId();
        }
    }
}
