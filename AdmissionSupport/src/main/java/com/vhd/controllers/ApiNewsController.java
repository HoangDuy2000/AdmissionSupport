/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.controllers;

import com.vhd.pojo.Comment;
import com.vhd.pojo.News;
import com.vhd.service.CommentService;
import com.vhd.service.NewsService;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
public class ApiNewsController {
    @Autowired
    private NewsService newsService;
    
    @Autowired
    private CommentService commentService;
    
    @DeleteMapping("/news/{newsId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable(value = "newsId") int id){
        this.newsService.deleteNews(id);
    }
    
    @GetMapping("/news/")
    @CrossOrigin
    public ResponseEntity<List<News>> List(@RequestParam Map<String, String> params){
        return new ResponseEntity<>(this.newsService.getNews(params), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/news/{newsId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<News> details(@PathVariable(value = "newsId") int id) {
        return new ResponseEntity<>(this.newsService.getNewsById(id), HttpStatus.OK);
    }
    
    @GetMapping("/news/{newsId}/comments/")
    @CrossOrigin
    public ResponseEntity<List<Comment>> listComments(@PathVariable(value = "newsId") int id) {
        return new ResponseEntity<>(this.commentService.getComments(id), HttpStatus.OK);
    }

    @PostMapping(path="/comments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment c = this.commentService.addComment(comment);

        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
