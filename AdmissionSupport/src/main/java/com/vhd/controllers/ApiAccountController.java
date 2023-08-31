/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.components.JwtService;
import com.vhd.pojo.Accounts;
import com.vhd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
public class ApiAccountController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AccountService accountService;
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Accounts account) {
        if (this.accountService.authUser(account.getUsername(), account.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(account.getUsername());

            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/test")
    @CrossOrigin(origins = {"127.0.0.1:5500"})
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
    }
}
