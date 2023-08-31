/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.Lives;
import com.vhd.service.LiveService;
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
public class LiveController {
    @Autowired
    private LiveService liveService;
    
    @GetMapping("/lives/")
    public String list(Model model) {
        model.addAttribute("live", new Lives());
        
        return "live";
    }
    
    @GetMapping("/lives/{livesId}")
    public String update(Model model, @PathVariable(value = "livesId") int id) {
        model.addAttribute("live", this.liveService.getLiveById(id));
        
        return "live";
    }
    
    @PostMapping("/lives/")
    public String add(@ModelAttribute(value = "live") @Valid Lives l, BindingResult rs) {
        if (!rs.hasErrors())
            if (this.liveService.addOrUpdateLive(l) == true)
                return "redirect:/lives";
        
        return "live";
    }
}
