/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.Scores;
import com.vhd.service.ScoreService;
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
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    
    @GetMapping("/admin/scores/")
    public String list(Model model) {
        model.addAttribute("scores", new Scores());
        
        return "score";
    }
    
    @GetMapping("/admin/scores/{scoresId}")
    public String update(Model model, @PathVariable(value = "scoresId") int id) {
        model.addAttribute("scores", this.scoreService.getScoreById(id));
        
        return "score";
    }
    
    @PostMapping("/admin/scores/")
    public String add(@ModelAttribute(value = "scores") @Valid Scores s, BindingResult rs) {
        if (!rs.hasErrors())
            if (this.scoreService.addOrUpdateScore(s) == true)
                return "redirect:/admin/scores";
        
        return "score";
    }
}
