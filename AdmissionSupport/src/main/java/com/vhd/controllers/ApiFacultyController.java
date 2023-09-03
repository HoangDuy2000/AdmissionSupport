/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.Facultys;
import com.vhd.pojo.Scores;
import com.vhd.service.FacultyService;
import com.vhd.service.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
public class ApiFacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private ScoreService scoreService;
    
    @DeleteMapping("/admin/facultys/{facultysId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFaculty(@PathVariable(value = "facultysId") int id){
        this.facultyService.deleteFaculty(id);
    }
    
    @GetMapping("/facultys/")
    @CrossOrigin
    public ResponseEntity<List<Facultys>> List(){        
        return new ResponseEntity<>(this.facultyService.getFacultys(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/facultys/{facultysId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Facultys> details(@PathVariable(value = "facultysId") int id) {
        return new ResponseEntity<>(this.facultyService.getFacultyById(id), HttpStatus.OK);
    }
    
    @GetMapping("/facultys/{facultysId}/scores/")
    @CrossOrigin
    public ResponseEntity<List<Scores>> listComments(@PathVariable(value = "facultysId") int id) {
        return new ResponseEntity<>(this.scoreService.getScores(id), HttpStatus.OK);
    }
}
