/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.components.JwtService;
import com.vhd.pojo.Accounts;
import com.vhd.service.AccountService;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    
    @PostMapping("/login/")
    @CrossOrigin
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
    
    @PostMapping(path = "/accounts/", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Accounts> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        Accounts account = this.accountService.addAccount(params, avatar);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Accounts> details(Principal user) {
        Accounts u = this.accountService.getAccountByname(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
