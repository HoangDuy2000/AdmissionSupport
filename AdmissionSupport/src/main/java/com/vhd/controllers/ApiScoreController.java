/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author PC
 */
@Controller
public class ApiScoreController {
    @Autowired
    private ScoreService scoreService;
    
    @DeleteMapping("/admin/scores/{scoresId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLives(@PathVariable(value = "scoresId") int id){
        this.scoreService.deleteScore(id);
    }
}
