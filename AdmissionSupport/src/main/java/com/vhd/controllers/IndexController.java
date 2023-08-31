/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.service.AccountService;
import com.vhd.service.FacultyService;
import com.vhd.service.LiveService;
import com.vhd.service.NewsService;
import com.vhd.service.QuestionService;
import com.vhd.service.ScoreService;
import com.vhd.service.TypeNewsService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@ControllerAdvice
public class IndexController {   
    @Autowired
    private NewsService newsService;
    
    @Autowired
    private TypeNewsService typeNewsService;
    
    @Autowired
    private FacultyService facultyService;
    
    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private ScoreService scoreService;
    
    @Autowired
    private LiveService liveService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private Environment env;
    
    @ModelAttribute
    public void commonAttr(Model model){
        model.addAttribute("typeNews", this.typeNewsService.getTypeNews());
        model.addAttribute("faculty", this.facultyService.getFacultys());
        model.addAttribute("live", this.liveService.getLives());
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("news", this.newsService.getNews(params));
        
        int count = this.newsService.countNews();
        model.addAttribute("countNews", count);
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(count*1.0/pageSize));
        
        return "index";
    }
    
    @RequestMapping("/lives")
    public String live(Model model){
        model.addAttribute("live", this.liveService.getLives());
        
        return "listLive";
    }
    
    @RequestMapping("/questions")
    public String question(Model model){
        model.addAttribute("ques", this.questionService.getQuestion());
        
        return "listQues";
    }
    
    @RequestMapping("/admin/facultys")
    public String facultys(Model model){
        model.addAttribute("facultys", this.facultyService.getFacultys());
        
        return "listFacultys";
    }
    
    @RequestMapping("/admin/scores")
    public String score(Model model){
        model.addAttribute("score", this.scoreService.getScores());
        
        return "listScore";
    }
    
    @RequestMapping("/admin/accounts")
    public String account(Model model){
        model.addAttribute("accounts", this.accountService.getAccounts());
        
        return "listAccount";
    }
    
}
