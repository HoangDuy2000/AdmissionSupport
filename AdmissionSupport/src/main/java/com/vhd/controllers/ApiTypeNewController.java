/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.TypeNews;
import com.vhd.service.TypeNewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
public class ApiTypeNewController {
    @Autowired
    private TypeNewsService typeNewsService;
    
    @GetMapping("/typenews/")
    @CrossOrigin
    public ResponseEntity<List<TypeNews>> List(){
        return new ResponseEntity<>(this.typeNewsService.getTypeNews(), HttpStatus.OK);
    }
}
