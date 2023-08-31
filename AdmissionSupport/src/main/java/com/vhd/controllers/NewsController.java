/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.News;
import com.vhd.service.NewsService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author PC
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/news")
    public String list(Model model) {
        model.addAttribute("news", new News());
        
        return "news";
    }
    
    @GetMapping("/news/{newsId}")
    public String update(Model model, @PathVariable(value = "newsId") int id) {
        model.addAttribute("news", this.newsService.getNewsById(id));
        
        return "news";
    }
    
    @PostMapping("/news")
    public String add(@ModelAttribute(value = "news") @Valid News n, BindingResult rs) {
        if (!rs.hasErrors())
            if (this.newsService.addOrUpdateNews(n) == true)
                return "redirect:/";
        
        return "news";
    }
}
