/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
public class ApiLiveController {
    @Autowired
    private LiveService liveService;
    
    @DeleteMapping("/lives/{livesId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLives(@PathVariable(value = "livesId") int id){
        this.liveService.deleteLive(id);
    }
}
