/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.Accounts;
import com.vhd.service.AccountService;
import com.vhd.service.RoleService;
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
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @ModelAttribute
    public void commonAttr(Model model){
        model.addAttribute("role", this.roleService.getRoles());
    }
    
    @GetMapping("/admin/accounts/")
    public String list(Model model) {
        model.addAttribute("accounts", new Accounts());
        
        return "account";
    }
    
    @GetMapping("/admin/accounts/{userId}")
    public String update(Model model, @PathVariable(value = "userId") int id) {
        model.addAttribute("accounts", this.accountService.getAccountById(id));
        
        return "account";
    }
    
    @PostMapping("/admin/accounts/")
    public String add(@ModelAttribute(value = "accounts") @Valid Accounts a, BindingResult rs) {
        if (!rs.hasErrors())
            if (this.accountService.addOrUpdateAccount(a) == true)
                return "redirect:/admin/accounts";
        
        return "account";
    }
}
