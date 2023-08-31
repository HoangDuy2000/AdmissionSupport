/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.Facultys;
import com.vhd.service.FacultyService;
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
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    
    @GetMapping("/admin/facultys/")
    public String list(Model model) {
        model.addAttribute("facultys", new Facultys());
        
        return "faculty";
    }
    
    @GetMapping("/admin/facultys/{facultysId}")
    public String update(Model model, @PathVariable(value = "facultysId") int id) {
        model.addAttribute("facultys", this.facultyService.getFacultyById(id));
        
        return "faculty";
    }
    
    @PostMapping("/admin/facultys/")
    public String add(@ModelAttribute(value = "facultys") @Valid Facultys f, BindingResult rs) {
        if (!rs.hasErrors())
            if (this.facultyService.addOrUpdateFaculty(f) == true)
                return "redirect:/admin/facultys";
        
        return "faculty";
    }
    
}
