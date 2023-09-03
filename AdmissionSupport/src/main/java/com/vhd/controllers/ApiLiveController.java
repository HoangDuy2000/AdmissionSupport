/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.Lives;
import com.vhd.pojo.Questions;
import com.vhd.service.LiveService;
import com.vhd.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
public class ApiLiveController {
    @Autowired
    private LiveService liveService;
    @Autowired
    private QuestionService questionService;
    
    @DeleteMapping("/lives/{livesId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLives(@PathVariable(value = "livesId") int id){
        this.liveService.deleteLive(id);
    }
    
    @GetMapping("/lives/")
    @CrossOrigin
    public ResponseEntity<List<Lives>> List(){
        return new ResponseEntity<>(this.liveService.getLives(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/lives/{livesId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Lives> details(@PathVariable(value = "livesId") int id) {
        return new ResponseEntity<>(this.liveService.getLiveById(id), HttpStatus.OK);
    }
    
    @GetMapping("/lives/{livesId}/questions/")
    @CrossOrigin
    public ResponseEntity<List<Questions>> listQuestions(@PathVariable(value = "livesId") int id) {
        return new ResponseEntity<>(this.questionService.getQuestions(id), HttpStatus.OK);
    }
    
    @PostMapping(path="/questions/add/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Questions> addQuestion(@RequestBody Questions question) {
        Questions ques = this.questionService.addQuestion(question);

        return new ResponseEntity<>(ques, HttpStatus.CREATED);
    }
}
