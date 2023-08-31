/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.Questions;
import com.vhd.service.QuestionService;
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
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    
    @GetMapping("/questions/")
    public String list(Model model) {
        model.addAttribute("question", new Questions());
        
        return "question";
    }
    
    @GetMapping("/questions/{questionsId}")
    public String update(Model model, @PathVariable(value = "questionsId") int id) {
        model.addAttribute("question", this.questionService.getQuestionById(id));
        
        return "question";
    }
    
    @PostMapping("/questions/")
    public String add(@ModelAttribute(value = "question") @Valid Questions ques, BindingResult rs) {
        if (!rs.hasErrors())
            if (this.questionService.addOrUpdateQuestion(ques) == true)
                return "redirect:/questions";
        
        return "question";
    }
}
