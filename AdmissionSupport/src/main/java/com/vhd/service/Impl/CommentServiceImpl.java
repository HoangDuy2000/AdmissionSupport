/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service.Impl;

import com.vhd.pojo.Accounts;
import com.vhd.pojo.Comment;
import com.vhd.repository.AccountRepository;
import com.vhd.repository.CommentRepository;
import com.vhd.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private AccountRepository accountRepo;
    
    @Override
    public List<Comment> getComments(int newsId) {
        return this.commentRepo.getComments(newsId);
    }

    @Override
    public Comment addComment(Comment c) {
        c.setCreatedDate(new Date());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Accounts u = this.accountRepo.getAccountByUsername(authentication.getName());
        c.setAccountId(u);

        return this.commentRepo.addComment(c);
    }
    
}
