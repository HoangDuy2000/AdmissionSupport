/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.Questions;
import com.vhd.service.QuestionService;
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
public class ApiQuestionController {
    @Autowired
    private QuestionService questionService;
    
    @GetMapping("/questions/")
    @CrossOrigin
    public ResponseEntity<List<Questions>> List(){
        return new ResponseEntity<>(this.questionService.getQuestion(), HttpStatus.OK);
    }
}
